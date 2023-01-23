package com.myrestaurantservice.PizzaRestaurantService.mapper;

import org.mapstruct.Mapper;

import com.myrestaurantservice.PizzaRestaurantService.dto.PizzaDTO;
import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;

@Mapper(componentModel = "spring")
public interface PizzaMapper extends GenericMapper<Pizza, PizzaDTO> {

}
