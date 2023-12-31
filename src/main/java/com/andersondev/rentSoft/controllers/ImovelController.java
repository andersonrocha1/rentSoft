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

import com.andersondev.rentSoft.dtos.ImovelRecordDto;
import com.andersondev.rentSoft.services.ImovelService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Validated
@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {
	
	private final ImovelService imovelService;

	public ImovelController(ImovelService imovelService) {
		
		this.imovelService = imovelService;
	}
	
	
	@GetMapping
	public List<ImovelRecordDto> list(){
		
		return imovelService.list();
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ImovelRecordDto create(@RequestBody @Valid ImovelRecordDto imovel) {
		
		return imovelService.create(imovel);
		
	}
	
	@GetMapping("/{id}")
	public ImovelRecordDto findById(@PathVariable @NotNull @Positive Long id) {
		
		return imovelService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ImovelRecordDto update(@PathVariable @NotNull @Positive Long id,
			@RequestBody @Valid ImovelRecordDto imovel) {
		
		return imovelService.update(id, imovel);
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable @NotNull @Positive Long id) {
		
		imovelService.delete(id);
	}

}
