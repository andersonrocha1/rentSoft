package com.andersondev.rentSoft.model;

import java.time.LocalDate;

import com.andersondev.rentSoft.enums.TipoConta;
import com.andersondev.rentSoft.enums.converters.TipoContaConverter;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Nonnull
	@Column(length = 12, nullable = false)
	@Convert(converter = TipoContaConverter.class)
    private TipoConta tipoConta;

    
    private double valor;
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioModel locatario;

    // getters e setters
}
