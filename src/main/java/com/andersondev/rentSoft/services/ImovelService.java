package com.andersondev.rentSoft.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.andersondev.rentSoft.dtos.ImovelRecordDto;
import com.andersondev.rentSoft.dtos.mapper.ImovelMapper;
import com.andersondev.rentSoft.exceptions.RecordNotFoundException;
import com.andersondev.rentSoft.repositories.ImovelRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Validated
@Service
public class ImovelService {
	
	
	private final ImovelRepository imovelRepository;
	
	private final ImovelMapper imovelMapper;

	
	
	
	public ImovelService(ImovelRepository imovelRepository, ImovelMapper imovelMapper) {
		
		this.imovelRepository = imovelRepository;
		this.imovelMapper = imovelMapper;
	}

	public List<ImovelRecordDto> list(){
		
		return imovelRepository.findAll()
				.stream()
				.map(imovelMapper::toDto)
				.collect(Collectors.toList());
		
	}
	
	public ImovelRecordDto findById(@NotNull @Positive Long id) {
		
		return imovelRepository.findById(id).map(imovelMapper::toDto)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	
	public ImovelRecordDto create(@Valid @NotNull ImovelRecordDto imovel) {

		return imovelMapper.toDto(imovelRepository.save(imovelMapper.toEntity(imovel)));

	}
	
	
	public ImovelRecordDto update(@NotNull @Positive Long id, @Valid ImovelRecordDto imovel) {

		return imovelRepository.findById(id).map(recordNotFound -> {

			
			recordNotFound.setNome(imovel.nome());
			recordNotFound.setEndereco(imovel.endereco());
			recordNotFound.setNumeroQuartos(imovel.numeroQuartos());
			recordNotFound.setPrecoAluguel(imovel.precoAluguel());
		
	
			return imovelMapper.toDto(imovelRepository.save(recordNotFound));

		}).orElseThrow(() -> new RecordNotFoundException(id));

	}
	
  
	public void delete(@NotNull @Positive Long id) {
		
		imovelRepository.delete(imovelRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));

		}

}
