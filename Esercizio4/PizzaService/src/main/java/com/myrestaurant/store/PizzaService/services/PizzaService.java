package com.myrestaurant.store.PizzaService.services;

import java.util.List;

import com.myrestaurant.store.PizzaService.models.Pizza;
import com.myrestaurant.store.PizzaService.models.RestaurantIds;

public interface PizzaService extends GenericService<Pizza, Long> {
	
	List<Pizza> findByRestaurantId(Long restaurantId);
	
	List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds);
	
}
