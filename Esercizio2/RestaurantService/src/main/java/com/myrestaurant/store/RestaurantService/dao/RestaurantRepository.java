package com.myrestaurant.store.RestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrestaurant.store.RestaurantService.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
