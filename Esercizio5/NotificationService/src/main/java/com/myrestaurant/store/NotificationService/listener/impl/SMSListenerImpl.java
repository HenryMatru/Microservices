package com.myrestaurant.store.NotificationService.listener.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.myrestaurant.store.NotificationService.listener.NotificationListener;
import com.myrestaurant.store.NotificationService.service.SMSService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("sms")
public class SMSListenerImpl implements NotificationListener {

	private final SMSService smsService;
	
	@Override
	@RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-routingkey}"})
	public void onNotifyPizzasToRestaurantAdded(String message) {
		log.info("Info SMSListenerImpl - onNotifyPizzasToRestaurantAdded method.");
		this.smsService.sendMessage(message);
	}

}
