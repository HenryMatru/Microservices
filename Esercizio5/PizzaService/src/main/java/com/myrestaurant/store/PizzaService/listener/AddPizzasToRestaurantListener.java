package com.myrestaurant.store.PizzaService.listener;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.myrestaurant.store.PizzaService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.PizzaService.mappers.RestaurantIdsMapper;
import com.myrestaurant.store.PizzaService.services.PizzaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddPizzasToRestaurantListener {
	
	private final PizzaService pizzaService;
	
	private final RestaurantIdsMapper restaurantIdsMapper;
	
	@RabbitListener(queues = {"${app.rabbitmq.add-pizzas-routingkey}"})
	public void addPizzaToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
		this.pizzaService.addPizzasToRestaurant(this.restaurantIdsMapper.asEntityList(restaurantIdsDTOS));
	}
	
}
