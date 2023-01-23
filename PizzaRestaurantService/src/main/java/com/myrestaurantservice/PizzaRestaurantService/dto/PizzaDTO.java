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
public class PizzaDTO {
	
	private Long id;
	
	private String name;
	
	private boolean favorite;
	
	@Builder.Default
	private Set<ToppingDTO> toppings = new HashSet<>();

}
