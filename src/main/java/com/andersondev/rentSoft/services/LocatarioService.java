package com.andersondev.rentSoft.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import com.andersondev.rentSoft.dtos.LocatarioRecordDto;
import com.andersondev.rentSoft.dtos.mapper.LocatarioMapper;
import com.andersondev.rentSoft.exceptions.RecordNotFoundException;
import com.andersondev.rentSoft.repositories.LocatarioRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Validated
@Service
public class LocatarioService {
	
	
	private final LocatarioRepository locatarioRepository;
	
	private final LocatarioMapper locatarioMapper;

	public LocatarioService(LocatarioRepository locatarioRepository, LocatarioMapper locatarioMapper) {
		
		this.locatarioRepository = locatarioRepository;
		this.locatarioMapper = locatarioMapper;
	}
	
	
	public List<LocatarioRecordDto> list(){
		
		return locatarioRepository.findAll()
				.stream()
				.map(locatarioMapper::toDto)
				.collect(Collectors.toList());
		
	}
	
	public LocatarioRecordDto findById(@NotNull @Positive Long id) {
		
		return locatarioRepository.findById(id).map(locatarioMapper::toDto)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	
	public LocatarioRecordDto create(@Valid @NotNull LocatarioRecordDto locatario) {

		return locatarioMapper.toDto(locatarioRepository.save(locatarioMapper.toEntity(locatario)));

	}
	
	
	public LocatarioRecordDto update(@NotNull @Positive Long id, @Valid LocatarioRecordDto locatario) {

		return locatarioRepository.findById(id).map(recordNotFound -> {

			recordNotFound.setNome(locatario.nome());
			recordNotFound.setCpf(locatario.cpf());
			
			
			return locatarioMapper.toDto(locatarioRepository.save(recordNotFound));

		}).orElseThrow(() -> new RecordNotFoundException(id));

	}
	
  
	public void delete(@NotNull @Positive Long id) {
		
		locatarioRepository.delete(locatarioRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(id)));

		}

}
