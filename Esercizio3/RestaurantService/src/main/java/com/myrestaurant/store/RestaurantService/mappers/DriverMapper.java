package com.myrestaurant.store.RestaurantService.mappers;

import org.mapstruct.Mapper;

import com.myrestaurant.store.RestaurantService.dto.DriverDTO;
import com.myrestaurant.store.RestaurantService.models.Driver;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {
	
}
