package com.myrestaurant.store.RestaurantService.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Profile("coll")
@Slf4j
public class DataSourceConfigColl {
	
	public DataSourceConfigColl() {
		log.info("Into DataSourceConfigColl class.");
	}

}
