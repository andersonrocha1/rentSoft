package com.andersondev.rentSoft.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ImovelRecordDto(
		
		Long id,
		
		@NotNull
		@NotBlank
		String nome,
		
		@NotNull
		@NotBlank
		String endereco,
		
		@NotNull
		@NotBlank
		int numeroQuartos,
		
		@NotBlank
		BigDecimal precoAluguel
		
		
		
		) {

}
