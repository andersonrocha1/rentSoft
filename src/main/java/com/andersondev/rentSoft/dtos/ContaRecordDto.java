package com.andersondev.rentSoft.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.andersondev.rentSoft.enums.TipoConta;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ContaRecordDto(
		
		
		
		
	    Long id,
	    
	    @NotNull @Length(max = 12) @Pattern(regexp = "Água|Energia")
	    TipoConta tipoConta,
	

	    @NotNull
	    @NotBlank
	    BigDecimal valor,
	    
	    @Column(name = "vencimento")
	    LocalDate dataVencimento
		
		) {

}
