package com.myrestaurant.store.NotificationService.service.impl;

import org.springframework.stereotype.Service;

import com.myrestaurant.store.NotificationService.service.SMSService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SMSServiceImpl implements SMSService {

	@Override
	public void sendMessage(String message) {
		log.info("SMS message {}", message);
	}

}
