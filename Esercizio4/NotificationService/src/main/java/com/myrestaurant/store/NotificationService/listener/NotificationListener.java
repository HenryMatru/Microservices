package com.myrestaurant.store.NotificationService.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.myrestaurant.store.NotificationService.service.EmailService;
import com.myrestaurant.store.NotificationService.service.SMSService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationListener {
	
	private final EmailService emailService;
	
	private final SMSService smsService;

	@RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
	public void onNotifyPizzasToRestaurantAdded(String message) {
		log.info("Info onAddPizzasToRestaurant method.");
		this.emailService.sendMessage(message);
		this.smsService.sendMessage(message);
	}
	
}
