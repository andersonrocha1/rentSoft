package com.andersondev.rentSoft.dtos.mapper;

import org.springframework.stereotype.Component;

import com.andersondev.rentSoft.dtos.ImovelRecordDto;
import com.andersondev.rentSoft.model.ImovelModel;
import com.andersondev.rentSoft.model.LocatarioModel;


@Component
public class ImovelMapper {
	
	public ImovelRecordDto toDto(ImovelModel imovel) {
		
		if(imovel == null) {

			return null;
		}
		return new ImovelRecordDto(imovel.getId(), imovel.getNome(), imovel.getEndereco(), imovel.getNumeroQuartos(),imovel.getPrecoAluguel());
	
	}
	
	
	public ImovelModel toEntity(ImovelRecordDto imovelDto) {

        if (imovelDto == null) {
            return null;
        }

        ImovelModel imoveis = new ImovelModel();
        if (imovelDto.id() != null) {
            imoveis.setId(imovelDto.id());
        }
        imoveis.setNome(imovelDto.nome());
        imoveis.setEndereco(imovelDto.endereco());
        imoveis.setNumeroQuartos(imovelDto.numeroQuartos());
        imoveis.setPrecoAluguel(imovelDto.precoAluguel());
        var locatario = new LocatarioModel();
        imoveis.setLocatarioAluga(locatario);
        
        
       
 
        return imoveis;
    }

}
