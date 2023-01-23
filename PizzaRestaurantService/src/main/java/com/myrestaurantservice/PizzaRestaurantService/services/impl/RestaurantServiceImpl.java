package com.myrestaurantservice.PizzaRestaurantService.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurantservice.PizzaRestaurantService.dao.RestaurantRepository;
import com.myrestaurantservice.PizzaRestaurantService.models.Restaurant;
import com.myrestaurantservice.PizzaRestaurantService.services.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant save(Restaurant entity) {
		return this.restaurantRepository.save(entity);
	}

	@Override
	public List<Restaurant> save(List<Restaurant> entities) {
		return (List<Restaurant>) this.restaurantRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		this.restaurantRepository.deleteById(id);
	}

	@Override
	public Optional<Restaurant> findById(Long id) {
		return this.restaurantRepository.findById(id);
	}

	@Override
	public List<Restaurant> findAll() {
		return (List<Restaurant>) this.restaurantRepository.findAll();
	}

	@Override
	public Restaurant update(Restaurant entity, Long id) {
		Optional<Restaurant> optional = this.findById(id);
		if (optional.isPresent()) {
			return this.save(entity);
		}
		return null;
	}
	
	@Override
	public Restaurant addPizzasToRestaurant(Restaurant restaurant) {
		return this.restaurantRepository.save(restaurant);
	}

}
