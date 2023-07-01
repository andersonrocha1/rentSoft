package com.andersondev.rentSoft.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LocatarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cpf;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "locatario")
    private List<Conta> contas = new ArrayList<>();

	// getters e setters

}
