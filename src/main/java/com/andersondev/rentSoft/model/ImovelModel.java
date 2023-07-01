package com.andersondev.rentSoft.model;

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
public class ImovelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    
    private int numeroQuartos;
    
    private double precoAluguel;
    
    
    @Nonnull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;
    
    // getters e setters
}
