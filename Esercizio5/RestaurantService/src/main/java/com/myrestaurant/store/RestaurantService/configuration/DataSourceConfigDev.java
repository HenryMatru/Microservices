package com.myrestaurant.store.RestaurantService.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("dev")
@Slf4j
public class DataSourceConfigDev {
	
	public DataSourceConfigDev() {
		log.info("Into DataSourceConfigDev class.");
	}
	
}
