package com.myrestaurantservice.PizzaRestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myrestaurantservice.PizzaRestaurantService.models.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {

}
