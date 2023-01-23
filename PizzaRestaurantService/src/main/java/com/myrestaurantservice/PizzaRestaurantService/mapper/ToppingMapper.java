package com.myrestaurantservice.PizzaRestaurantService.mapper;

import org.mapstruct.Mapper;

import com.myrestaurantservice.PizzaRestaurantService.dto.ToppingDTO;
import com.myrestaurantservice.PizzaRestaurantService.models.Topping;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO> {

}
