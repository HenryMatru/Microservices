package com.myrestaurantservice.PizzaRestaurantService.dto;

import java.util.HashSet;
import java.util.Set;

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
public class RestaurantDTO {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	@Builder.Default
	private Set<DriverDTO> drivers = new HashSet<>();
	
	@Builder.Default
	private Set<PizzaDTO> pizzas = new HashSet<>();
	
}
