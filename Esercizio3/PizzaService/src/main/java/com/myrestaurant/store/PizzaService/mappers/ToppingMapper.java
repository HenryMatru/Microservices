package com.myrestaurant.store.PizzaService.mappers;

import org.mapstruct.Mapper;

import com.myrestaurant.store.PizzaService.dto.ToppingDTO;
import com.myrestaurant.store.PizzaService.models.Topping;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO> {

}
