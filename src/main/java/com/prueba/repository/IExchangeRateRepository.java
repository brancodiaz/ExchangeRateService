package com.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.model.TipoCambioEnt;

@Repository
public interface IExchangeRateRepository  extends JpaRepository<TipoCambioEnt, String> {
	
}
