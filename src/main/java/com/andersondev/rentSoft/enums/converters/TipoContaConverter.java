package com.andersondev.rentSoft.enums.converters;


import java.util.stream.Stream;

import com.andersondev.rentSoft.enums.TipoConta;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class TipoContaConverter implements AttributeConverter<TipoConta, String> {

	@Override
	public String convertToDatabaseColumn(TipoConta tipo) {
		if(tipo == null) {
			return null;
		}
		return tipo.getValue();
	}

	@Override
	public TipoConta convertToEntityAttribute(String value) {
		if(value == null) {
			
			return null;
		}
		return Stream.of(TipoConta.values())
				.filter(t -> t.getValue().equals(value))
				.findFirst()
				.orElseThrow(IllegalArgumentException :: new);
	}

}
