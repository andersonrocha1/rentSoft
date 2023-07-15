package com.andersondev.rentSoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.andersondev.rentSoft.enums.Status;
import com.andersondev.rentSoft.enums.TipoConta;
import com.andersondev.rentSoft.enums.converters.StatusConverter;
import com.andersondev.rentSoft.enums.converters.TipoContaConverter;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;




@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name="tb_conta")
public class Conta implements Serializable {
  
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
	@Column(length = 12, nullable = false)
	@Convert(converter = TipoContaConverter.class)
    private TipoConta tipoConta;
    
    
    @Nonnull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;

    @NotNull
    private BigDecimal valor;
    
    @Column(name = "vencimento")
    private LocalDate dataVencimento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locatario_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocatarioModel locatario;
    
    public Conta() {
    	
    }

	public Conta(Long id, @NotNull TipoConta tipoConta, Status status, @NotNull @NotBlank BigDecimal valor,
			LocalDate dataVencimento, LocatarioModel locatario) {
		super();
		this.id = id;
		this.tipoConta = tipoConta;
		this.status = status;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.locatario = locatario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
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
		Conta other = (Conta) obj;
		return Objects.equals(id, other.id) && status == other.status;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", tipoConta=" + tipoConta + ", status=" + status + ", valor=" + valor
				+ ", dataVencimento=" + dataVencimento + ", locatario=" + locatario + "]";
	}
    

	
	
	
    
}
