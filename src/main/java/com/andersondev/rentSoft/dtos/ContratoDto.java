package com.andersondev.rentSoft.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratoDto(
		
		Long id,

		LocalDate dataInicio,

		LocalDate dataFinal,

		BigDecimal deposito,

		BigDecimal valorMensal

) {

}
