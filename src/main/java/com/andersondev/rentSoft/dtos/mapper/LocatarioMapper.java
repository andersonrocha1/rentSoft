package com.andersondev.rentSoft.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.andersondev.rentSoft.dtos.ContaRecordDto;
import com.andersondev.rentSoft.dtos.ImovelRecordDto;
import com.andersondev.rentSoft.dtos.LocatarioRecordDto;
import com.andersondev.rentSoft.model.LocatarioModel;


@Component
public class LocatarioMapper {
	
	public LocatarioRecordDto toDto(LocatarioModel locatario) {
		
		if(locatario == null) {
			return null;
		}
		
		List<ImovelRecordDto> imoveis = locatario.getImoveis()
        		.stream()
        		.map(imovel -> new ImovelRecordDto(imovel.getId(),imovel.getNome(), imovel.getEndereco(),
        				imovel.getNumeroQuartos(), imovel.getPrecoAluguel()))
        		.collect(Collectors.toList());
		List<ContaRecordDto> contas = locatario.getContas()
				.stream()
				.map(conta -> new ContaRecordDto(conta.getId(), conta.getTipoConta(), conta.getValor(), conta.getDataVencimento()))
				.collect(Collectors.toList());
				
        return new LocatarioRecordDto(locatario.getId(), locatario.getNome(), locatario.getCpf(), imoveis, contas);
		
	}
	
	public LocatarioModel toEntity(LocatarioRecordDto locatarioDto) {

        if (locatarioDto == null) {
            return null;
        }

        LocatarioModel locatarios = new LocatarioModel();
        if (locatarioDto.id() != null) {
            locatarios.setId(locatarioDto.id());
        }
        locatarios.setNome(locatarioDto.nome());
        locatarios.setCpf(locatarioDto.cpf());
        
           
        return locatarios;
    }

}
