package com.myrestaurant.store.RestaurantService.controllers.impl;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;

@FeignClient(name="PIZZA-SERVICE")
public interface PizzaServiceProxyClient {
	
	@PostMapping("/api/pizzas/restaurant")
    public List<Object> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);

    @GetMapping("/api/pizzas/restaurant/{id}")
    public List<Object> findPizzaByRestaurant(@PathVariable("id") Long restaurantId);
	
}
