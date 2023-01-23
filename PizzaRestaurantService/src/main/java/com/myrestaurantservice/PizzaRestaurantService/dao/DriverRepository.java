package com.myrestaurantservice.PizzaRestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrestaurantservice.PizzaRestaurantService.models.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}
