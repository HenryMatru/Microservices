package com.myrestaurant.store.NotificationService.service.impl;

import org.springframework.stereotype.Service;

import com.myrestaurant.store.NotificationService.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

	@Override
	public void sendMessage(String message) {
		log.info("Email message: {} ", message);
	}
	
}
