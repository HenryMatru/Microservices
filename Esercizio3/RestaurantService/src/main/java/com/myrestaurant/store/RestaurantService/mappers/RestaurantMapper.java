package com.myrestaurant.store.RestaurantService.mappers;

import org.mapstruct.Mapper;

import com.myrestaurant.store.RestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.RestaurantService.models.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO> {
	
}
