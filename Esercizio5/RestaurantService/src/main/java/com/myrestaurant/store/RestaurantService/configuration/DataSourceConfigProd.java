package com.myrestaurant.store.RestaurantService.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("prod")
@Slf4j
public class DataSourceConfigProd {
	
	public DataSourceConfigProd() {
		log.info("Into DataSourceConfigProd class.");
	}
	
}
