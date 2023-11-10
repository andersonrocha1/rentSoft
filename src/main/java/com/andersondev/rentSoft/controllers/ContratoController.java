package com.andersondev.rentSoft.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andersondev.rentSoft.dtos.ContratoDto;
import com.andersondev.rentSoft.services.ContratoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/contratos")
public class ContratoController {
	
	private final ContratoService contratoService;

	public ContratoController(ContratoService contratoService) {
		
		this.contratoService = contratoService;
	}
	
	
	@GetMapping
	public List<ContratoDto> list(){
		
		return contratoService.list();
		
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContratoDto create(@RequestBody @Valid ContratoDto contrato) {
		
		return contratoService.create(contrato);
	}
	
	@GetMapping("/{id}")
	public ContratoDto findById(@PathVariable @NotNull @Positive Long id) {
		
		return contratoService.findById(id);
		
	}
	
	@PutMapping("/{id}")
	public ContratoDto update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid ContratoDto contrato) {
		
		return contratoService.update(id, contrato);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {
		
		contratoService.delete(id);
	}
	
	

}
