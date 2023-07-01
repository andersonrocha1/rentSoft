package com.andersondev.rentSoft.model;

import java.time.LocalDate;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@SQLDelete(sql = "UPDATE tb_courses SET status = 'Inativo' WHERE id = ? ")
@Where(clause = "status = 'Ativo'")
@Table(name="tb_contrato")
public class ContratoAluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private ImovelModel imovel;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;
    
    @Column(name = "data_final")
    private LocalDate dataFinal;
    
    @Nonnull
	@Column(length = 10, nullable = false)
	@Convert(converter = StatusConverter.class)
	private Status status = Status.ACTIVE;
    
    @ManyToOne
    @JoinColumn(name = "locatario_id")
    private LocatarioModel locatario;

    
    
    // getters e setters
}
