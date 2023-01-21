package com.myrestaurantservice.PizzaRestaurantService.dto;

import java.util.HashSet;
import java.util.Set;

import com.myrestaurantservice.PizzaRestaurantService.models.Topping;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PizzaDTO {
	
	private Long id;
	
	private String name;
	
	private boolean favorite;
	
	private Set<Topping> toppings = new HashSet<>();

}
