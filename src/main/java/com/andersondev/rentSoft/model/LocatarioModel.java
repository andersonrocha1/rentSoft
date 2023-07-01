package com.andersondev.rentSoft.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.andersondev.rentSoft.enums.Status;
import com.andersondev.rentSoft.enums.converters.StatusConverter;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name = "tb_locatario")
public class LocatarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String cpf;

	@Nonnull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "locatario")
	private List<Conta> contas = new ArrayList<>();

	// getters e setters

}
