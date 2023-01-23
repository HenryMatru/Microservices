package com.myrestaurantservice.PizzaRestaurantService.mapper;

import org.mapstruct.Mapper;

import com.myrestaurantservice.PizzaRestaurantService.dto.DriverDTO;
import com.myrestaurantservice.PizzaRestaurantService.models.Driver;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {

}
