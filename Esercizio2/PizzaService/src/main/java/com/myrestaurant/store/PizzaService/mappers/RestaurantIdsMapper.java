package com.myrestaurant.store.PizzaService.mappers;

import org.mapstruct.Mapper;

import com.myrestaurant.store.PizzaService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.PizzaService.models.RestaurantIds;

@Mapper(componentModel = "spring")
public interface RestaurantIdsMapper extends GenericMapper<RestaurantIds, RestaurantIdsDTO> {

}
