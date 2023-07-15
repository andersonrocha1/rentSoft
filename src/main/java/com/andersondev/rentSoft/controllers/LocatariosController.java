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


import com.andersondev.rentSoft.dtos.LocatarioRecordDto;
import com.andersondev.rentSoft.services.LocatarioService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/locatarios")
public class LocatariosController {
	
	private final LocatarioService locatarioService ;

	public LocatariosController(LocatarioService locatarioService) {
		
		this.locatarioService = locatarioService;
	}
	
	
	@GetMapping
	public List<LocatarioRecordDto> list() {

		return locatarioService.list();
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public LocatarioRecordDto create(@RequestBody @Valid LocatarioRecordDto locatario) {

		return locatarioService.create(locatario);
		// return
		// ResponseEntity.status(HttpStatus.CREATED).body(locatarioRepository.save(locatario));

	}
	
	
	@GetMapping("/{id}")
	public LocatarioRecordDto findById(@PathVariable @NotNull @Positive Long id) {

		return locatarioService.findById(id);
	}
	
	
	@PutMapping("/{id}")
	public LocatarioRecordDto update(@PathVariable @NotNull @Positive Long id,
			@RequestBody @Valid LocatarioRecordDto locatario) {

		return locatarioService.update(id, locatario);

	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {

		locatarioService.delete(id);

	}
	
	

}
