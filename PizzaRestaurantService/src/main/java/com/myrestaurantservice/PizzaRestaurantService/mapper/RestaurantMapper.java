package com.myrestaurantservice.PizzaRestaurantService.mapper;

import org.mapstruct.Mapper;

import com.myrestaurantservice.PizzaRestaurantService.dto.RestaurantDTO;
import com.myrestaurantservice.PizzaRestaurantService.models.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO> {

}
