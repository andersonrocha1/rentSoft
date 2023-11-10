package com.andersondev.rentSoft.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocatarioImovelDto(

		Long id,
		
		@NotBlank @NotNull String nome,

		@NotBlank @NotNull String cpf

) {
	
	

}
