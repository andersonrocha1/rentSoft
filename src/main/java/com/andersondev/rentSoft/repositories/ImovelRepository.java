package com.andersondev.rentSoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andersondev.rentSoft.model.ImovelModel;


public interface ImovelRepository extends JpaRepository<ImovelModel, Long> {

}
