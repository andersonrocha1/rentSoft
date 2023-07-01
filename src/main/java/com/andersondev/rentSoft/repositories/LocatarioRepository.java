package com.andersondev.rentSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersondev.rentSoft.model.LocatarioModel;


public interface LocatarioRepository extends JpaRepository<LocatarioModel, Long> {

}
