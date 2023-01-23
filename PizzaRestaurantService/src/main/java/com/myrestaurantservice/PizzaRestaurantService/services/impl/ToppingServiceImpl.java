package com.myrestaurantservice.PizzaRestaurantService.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurantservice.PizzaRestaurantService.dao.ToppingRepository;
import com.myrestaurantservice.PizzaRestaurantService.models.Topping;
import com.myrestaurantservice.PizzaRestaurantService.services.ToppingService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ToppingServiceImpl implements ToppingService {
	
	private final ToppingRepository toppingRepository;
	
	@Override
	public Topping save(Topping entity) {
		return this.toppingRepository.save(entity);
	}

	@Override
	public List<Topping> save(List<Topping> entities) {
		return (List<Topping>) this.toppingRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		this.toppingRepository.deleteById(id);
	}

	@Override
	public Optional<Topping> findById(Long id) {
		return this.toppingRepository.findById(id);
	}

	@Override
	public List<Topping> findAll() {
		return (List<Topping>) this.toppingRepository.findAll();
	}

	@Override
	public Topping update(Topping entity, Long id) {
		Optional<Topping> optional = this.findById(id);
		if (optional.isPresent()) {
			return this.save(entity);
		}
		return null;
	}

}
