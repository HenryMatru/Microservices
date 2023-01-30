package com.myrestaurant.store.NotificationService.listener.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.myrestaurant.store.NotificationService.listener.NotificationListener;
import com.myrestaurant.store.NotificationService.service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("email")
public class EmailListenerImpl implements NotificationListener {
	
	private final EmailService emailService;
	
	@Override
	@RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
	public void onNotifyPizzasToRestaurantAdded(String message) {
		log.info("Info EmailListenerImpl - onNotifyPizzasToRestaurantAdded method.");
		this.emailService.sendMessage(message);
	}
	
}
