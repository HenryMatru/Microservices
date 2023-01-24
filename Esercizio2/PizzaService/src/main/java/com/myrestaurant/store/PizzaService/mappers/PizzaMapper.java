package com.myrestaurant.store.PizzaService.mappers;

import org.mapstruct.Mapper;

import com.myrestaurant.store.PizzaService.dto.PizzaDTO;
import com.myrestaurant.store.PizzaService.models.Pizza;

@Mapper(componentModel = "spring")
public interface PizzaMapper extends GenericMapper<Pizza, PizzaDTO> {
}