package com.andersondev.rentSoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.andersondev.rentSoft.enums.Status;
import com.andersondev.rentSoft.enums.converters.StatusConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name = "tb_locatario")
public class LocatarioModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@NotNull
	private String nome;

	@NotBlank
	@NotNull
	private String cpf;

	@NotNull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy = "locatarioAluga")
	private List<ImovelModel> imoveis = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy = "locatario")
	private List<Conta> contas = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER, mappedBy = "locatarioContrata")
	private List<ContratoAluguel> contratos = new ArrayList<>();	
	

	public LocatarioModel() {
		
	}


	public LocatarioModel(Long id, @NotBlank @NotNull String nome, @NotBlank @NotNull String cpf,
			@NotNull Status status, List<ImovelModel> imoveis, List<Conta> contas, List<ContratoAluguel> contratos ) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
		this.imoveis = imoveis;
		this.contas = contas;
		this.contratos = contratos;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	public List<ImovelModel> getImoveis(){
		return imoveis;
	}


	public List<Conta> getContas() {
		return contas;
	}
	

	public void setImoveis(List<ImovelModel> imoveis) {
		this.imoveis = imoveis;
	}


	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	


	public List<ContratoAluguel> getContratos() {
		return contratos;
	}


	public void setContratos(List<ContratoAluguel> contratos) {
		this.contratos = contratos;
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
		LocatarioModel other = (LocatarioModel) obj;
		return Objects.equals(id, other.id) && status == other.status;
	}


	@Override
	public String toString() {
		return "LocatarioModel [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", status=" + status + ", imoveis="
				+ imoveis + ", contas=" + contas + ", contratos=" + contratos + "]";
	}



}
