package com.myrestaurantservice.PizzaRestaurantService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;
import com.myrestaurantservice.PizzaRestaurantService.models.Restaurant;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
	List<Pizza> findByRestaurantsIn(List<Restaurant> restaurants);
	
}
