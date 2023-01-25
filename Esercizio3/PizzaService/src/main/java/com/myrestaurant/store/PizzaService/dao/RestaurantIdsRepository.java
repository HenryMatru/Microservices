package com.myrestaurant.store.PizzaService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurant.store.PizzaService.models.RestaurantIds;
import com.myrestaurant.store.PizzaService.models.RestaurantIdsPK;

@Repository
public interface RestaurantIdsRepository extends JpaRepository<RestaurantIds, RestaurantIdsPK> {

	List<RestaurantIds> findByRestaurantId(Long restaurantId);
	
}
