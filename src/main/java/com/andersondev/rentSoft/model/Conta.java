package com.andersondev.rentSoft.model;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.andersondev.rentSoft.enums.Status;
import com.andersondev.rentSoft.enums.TipoConta;
import com.andersondev.rentSoft.enums.converters.StatusConverter;
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
import jakarta.persistence.Table;




@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name="tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Nonnull
	@Column(length = 12, nullable = false)
	@Convert(converter = TipoContaConverter.class)
    private TipoConta tipoConta;
    
    
    @Nonnull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;

    
    private double valor;
    
    @Column(name = "vencimento")
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioModel locatario;

    // getters e setters
}
