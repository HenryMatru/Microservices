package com.myrestaurantservice.PizzaRestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
