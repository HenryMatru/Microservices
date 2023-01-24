package com.myrestaurant.store.PizzaService.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myrestaurant.store.PizzaService.dao.ToppingRepository;
import com.myrestaurant.store.PizzaService.models.Topping;
import com.myrestaurant.store.PizzaService.services.ToppingService;

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
