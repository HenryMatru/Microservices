package com.myrestaurant.store.RestaurantService.listener;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PizzasToRestaurantAddedListener {
	
	@RabbitListener(queues = {"${app.rabbitmq.pizzas-added-routingkey}"})
	public void onPizzasToRestaurantAdded(List<Object> pizzas) {
		log.info("Into onPizzasToRestaurantAdded method.");
		
		for (Object pizza : pizzas) {
			log.info("Pizza -> " + pizza.toString());
		}
	}
	
}
