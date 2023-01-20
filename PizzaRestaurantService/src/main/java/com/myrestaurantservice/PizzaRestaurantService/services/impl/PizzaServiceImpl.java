package com.myrestaurantservice.PizzaRestaurantService.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurantservice.PizzaRestaurantService.dao.PizzaRepository;
import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;
import com.myrestaurantservice.PizzaRestaurantService.services.PizzaService;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

	private final PizzaRepository pizzaRepository;
	
	@Override
	public Pizza save(Pizza entity) {
		return this.pizzaRepository.save(entity);
	}

	@Override
	public List<Pizza> save(List<Pizza> entities) {
		return (List<Pizza>) this.pizzaRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		this.pizzaRepository.deleteById(id);
	}

	@Override
	public Optional<Pizza> findById(Long id) {
		return this.pizzaRepository.findById(id);
	}

	@Override
	public List<Pizza> findAll() {
		return (List<Pizza>) this.pizzaRepository.findAll();
	}

	@Override
	public Pizza update(Pizza entity, Long id) {
		Optional<Pizza> optional = this.findById(id);
		if (optional.isPresent()) {
			this.save(entity);
		}
		return null;
	}

}
