package com.andersondev.rentSoft.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.andersondev.rentSoft.dtos.ContaRecordDto;
import com.andersondev.rentSoft.dtos.ContratoDto;
import com.andersondev.rentSoft.dtos.ImovelRecordDto;
import com.andersondev.rentSoft.dtos.LocatarioRecordDto;
import com.andersondev.rentSoft.enums.TipoConta;
import com.andersondev.rentSoft.model.Conta;
import com.andersondev.rentSoft.model.ContratoAluguel;
import com.andersondev.rentSoft.model.ImovelModel;
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
		
		List<ContratoDto> contratos = locatario.getContratos()
				.stream()
				.map(contrato -> new ContratoDto(contrato.getId(), contrato.getDataInicio(), contrato.getDataFinal(), 
						contrato.getDeposito(), contrato.getValorMensal()))
				.collect(Collectors.toList());
				
        return new LocatarioRecordDto(locatario.getId(), locatario.getNome(), locatario.getCpf(), imoveis, contas, contratos);
        
        
		
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
        
        List<ImovelModel> imoveis = locatarioDto.imoveis().stream().map(imovelRecordDto -> {
        	
        	var imovel = new ImovelModel();
        	imovel.setId(imovelRecordDto.id());
        	imovel.setNome(imovelRecordDto.nome());
        	imovel.setEndereco(imovelRecordDto.endereco());
        	imovel.setNumeroQuartos(imovelRecordDto.numeroQuartos());
        	imovel.setPrecoAluguel(imovelRecordDto.precoAluguel());
        	imovel.setLocatarioAluga(locatarios);
        	
        	return imovel;
        	
        }).collect(Collectors.toList());
        
        List<Conta> contas = locatarioDto.contas().stream().map(contaRecordDto -> {
        	
        	var conta = new Conta();
        	conta.setId(contaRecordDto.id());
        	conta.setTipoConta(contaRecordDto.tipoConta());
        	conta.setValor(contaRecordDto.valor());
        	conta.setDataVencimento(contaRecordDto.dataVencimento());
        	conta.setLocatario(locatarios);
        	
        	return conta;
        	
        }).collect(Collectors.toList());
        
        List<ContratoAluguel> contratos = locatarioDto.contratos().stream().map(contratoDto -> {
        	
        	var contrato = new ContratoAluguel();
        	contrato.setId(contratoDto.id());
        	contrato.setDataInicio(contratoDto.dataInicio());
        	contrato.setDataFinal(contratoDto.dataFinal());
        	contrato.setDeposito(contratoDto.deposito());
        	contrato.setValorMensal(contratoDto.valorMensal());
        	contrato.setLocatarioContrata(locatarios);
        	
        	return contrato;
        	
        }).collect(Collectors.toList());
        
        locatarios.setImoveis(imoveis);
        locatarios.setContas(contas);
        locatarios.setContratos(contratos);
        
           
        return locatarios;
    }
	
	public TipoConta convertTipoContaValue(String value) {
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Energia" -> TipoConta.ENERGIA;
            case "Água" -> TipoConta.AGUA;
            default -> throw new IllegalArgumentException("Conta inválida: " + value);
        };
    }

}
