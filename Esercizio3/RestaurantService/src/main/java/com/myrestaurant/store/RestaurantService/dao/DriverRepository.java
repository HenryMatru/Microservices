package com.myrestaurant.store.RestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrestaurant.store.RestaurantService.models.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}
