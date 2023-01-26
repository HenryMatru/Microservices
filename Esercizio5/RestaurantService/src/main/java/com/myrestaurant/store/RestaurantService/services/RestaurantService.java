package com.myrestaurant.store.RestaurantService.services;

import java.util.List;

import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.RestaurantService.models.Restaurant;

public interface RestaurantService extends GenericService<Restaurant, Long> {
	
	public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);
	
}