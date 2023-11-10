package com.andersondev.rentSoft.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.andersondev.rentSoft.dtos.ContratoDto;
import com.andersondev.rentSoft.dtos.mapper.ContratoMapper;
import com.andersondev.rentSoft.exceptions.RecordNotFoundException;
import com.andersondev.rentSoft.repositories.ContratoAluguelRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class ContratoService {

	private final ContratoAluguelRepository contratoRepository;
	private final ContratoMapper contratoMapper;

	public ContratoService(ContratoAluguelRepository contratoRepository, ContratoMapper contratoMapper) {

		this.contratoRepository = contratoRepository;
		this.contratoMapper = contratoMapper;
	}

	public List<ContratoDto> list() {

		return contratoRepository.findAll().stream().map(contratoMapper::toDto).collect(Collectors.toList());

	}

	public ContratoDto findById(@NotNull @Positive Long id) {

		return contratoRepository.findById(id).map(contratoMapper::toDto)
				.orElseThrow(() -> new RecordNotFoundException(id));
	}

	public ContratoDto create(@Valid @NotNull ContratoDto contrato) {

		return contratoMapper.toDto(contratoRepository.save(contratoMapper.toEntity(contrato)));

	}

	public ContratoDto update(@NotNull @Positive Long id, @Valid ContratoDto contrato) {

		return contratoRepository.findById(id).map(recordNotFound -> {

			recordNotFound.setDataInicio(contrato.dataInicio());
			recordNotFound.setDataFinal(contrato.dataFinal());
			recordNotFound.setDeposito(contrato.deposito());
			recordNotFound.setValorMensal(contrato.valorMensal());

			return contratoMapper.toDto(contratoRepository.save(recordNotFound));

		}).orElseThrow(() -> new RecordNotFoundException(id));

	}

	public void delete(@NotNull @Positive Long id) {

		contratoRepository.delete(contratoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));

	}

}
