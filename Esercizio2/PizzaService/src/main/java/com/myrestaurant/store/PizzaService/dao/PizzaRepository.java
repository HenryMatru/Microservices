package com.myrestaurant.store.PizzaService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurant.store.PizzaService.models.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
	
}
