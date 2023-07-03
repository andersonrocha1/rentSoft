package com.andersondev.rentSoft.model;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.andersondev.rentSoft.enums.Status;
import com.andersondev.rentSoft.enums.converters.StatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name="tb_contrato")
public class ContratoAluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private ImovelModel imovel;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    
    @Column(name = "data_final")
    private LocalDate dataFinal;
    
    @NotNull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;
    
    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioModel locatario;

    
    public ContratoAluguel() {
    	
    }


	public ContratoAluguel(Long id, ImovelModel imovel, LocalDate dataInicio, LocalDate dataFinal,
			@NotNull Status status, LocatarioModel locatario) {
		super();
		this.id = id;
		this.imovel = imovel;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.status = status;
		this.locatario = locatario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ImovelModel getImovel() {
		return imovel;
	}


	public void setImovel(ImovelModel imovel) {
		this.imovel = imovel;
	}


	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public LocalDate getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public LocatarioModel getLocatario() {
		return locatario;
	}


	public void setLocatario(LocatarioModel locatario) {
		this.locatario = locatario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContratoAluguel other = (ContratoAluguel) obj;
		return Objects.equals(id, other.id) && status == other.status;
	}


	@Override
	public String toString() {
		return "ContratoAluguel [id=" + id + ", imovel=" + imovel + ", dataInicio=" + dataInicio + ", dataFinal="
				+ dataFinal + ", status=" + status + ", locatario=" + locatario + "]";
	}
    
    
	
}
