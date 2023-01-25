package com.myrestaurant.store.PizzaService.models;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantIdsPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long restaurantId;
	
	private Long pizzaId;
	
}
