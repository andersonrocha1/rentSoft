package com.andersondev.rentSoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.andersondev.rentSoft.enums.Status;
import com.andersondev.rentSoft.enums.converters.StatusConverter;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name="tb_imovel")
public class ImovelModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    
    private int numeroQuartos;
    
    private BigDecimal precoAluguel;
    
    
    @Nonnull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;
    
    
    public ImovelModel() {
    	
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public int getNumeroQuartos() {
		return numeroQuartos;
	}


	public void setNumeroQuartos(int numeroQuartos) {
		this.numeroQuartos = numeroQuartos;
	}


	public BigDecimal getPrecoAluguel() {
		return precoAluguel;
	}


	public void setPrecoAluguel(BigDecimal precoAluguel) {
		this.precoAluguel = precoAluguel;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
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
		ImovelModel other = (ImovelModel) obj;
		return Objects.equals(id, other.id) && status == other.status;
	}
   
    
    
}
