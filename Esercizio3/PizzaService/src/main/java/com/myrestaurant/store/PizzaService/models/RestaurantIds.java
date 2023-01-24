package com.myrestaurant.store.PizzaService.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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
@Entity
@Table(name = "restaurant_ids")
@IdClass(RestaurantIdsPK.class)
public class RestaurantIds implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long restaurantId;
	
	@Id
	private Long pizzaId;
	
}
