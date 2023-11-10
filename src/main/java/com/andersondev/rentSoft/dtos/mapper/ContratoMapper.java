package com.andersondev.rentSoft.dtos.mapper;

import org.springframework.stereotype.Component;

import com.andersondev.rentSoft.dtos.ContratoDto;
import com.andersondev.rentSoft.model.ContratoAluguel;
import com.andersondev.rentSoft.model.ImovelModel;
import com.andersondev.rentSoft.model.LocatarioModel;

@Component
public class ContratoMapper {
	
	public ContratoDto toDto(ContratoAluguel contratoAluguel) {
		
		if(contratoAluguel == null) {
			
			return null;
		}
		return new ContratoDto(contratoAluguel.getId(), contratoAluguel.getDataInicio(), contratoAluguel.getDataFinal(), contratoAluguel.getDeposito(), contratoAluguel.getValorMensal());
		
	}
	
	
	public ContratoAluguel toEntity(ContratoDto contratoDto) {
		
		if (contratoDto == null) {
            return null;
        }
		
		ContratoAluguel contrato = new ContratoAluguel();
		if (contratoDto.id() != null) {
			
			contrato.setId(contratoDto.id());
		}
		
		contrato.setDataInicio(contratoDto.dataInicio());
		contrato.setDataFinal(contratoDto.dataFinal());
		contrato.setDeposito(contratoDto.deposito());
		contrato.setValorMensal(contratoDto.valorMensal());
		
		var imovel = new ImovelModel();
		
		contrato.setImovel(imovel);
		
		var locatario = new LocatarioModel();
		
		contrato.setLocatarioContrata(locatario);
		
		return contrato;
		
	}

}
