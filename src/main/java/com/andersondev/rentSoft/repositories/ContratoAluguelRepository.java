package com.andersondev.rentSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersondev.rentSoft.model.ContratoAluguel;

public interface ContratoAluguelRepository extends JpaRepository<ContratoAluguel, Long> {
	
}
