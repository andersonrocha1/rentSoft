package com.andersondev.rentSoft.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LocatarioRecordDto(

		Long id,
		
		@NotBlank @NotNull String nome,

		@NotBlank @NotNull String cpf,

		List<ContaRecordDto> contas

) {

}
