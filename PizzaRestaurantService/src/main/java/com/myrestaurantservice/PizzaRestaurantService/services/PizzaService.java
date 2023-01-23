package com.myrestaurantservice.PizzaRestaurantService.services;

import java.util.List;

import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;

public interface PizzaService extends GenericService<Pizza, Long> {
	
	List<Pizza> findByRestaurantId(Long restaurantId);
	
}
