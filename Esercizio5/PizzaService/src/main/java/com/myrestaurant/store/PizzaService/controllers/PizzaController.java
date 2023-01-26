package com.myrestaurant.store.PizzaService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurant.store.PizzaService.dto.PizzaDTO;
import com.myrestaurant.store.PizzaService.dto.RestaurantIdsDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pizza API")
public interface PizzaController {

    @ApiOperation("Add new pizza")
    PizzaDTO save(@RequestBody PizzaDTO pizzaDTO);

    @ApiOperation("Find pizza by ID")
    PizzaDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete pizza by ID")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all pizzas")
    List<PizzaDTO> list();

    @ApiOperation("Update pizza")
    PizzaDTO update(@RequestBody PizzaDTO pizzaDTO, @PathVariable("id") Long id);

    @ApiOperation("Find by Restaurant ID")
    public List<PizzaDTO> findByRestaurantId(@PathVariable("id") Long id);
    
    @ApiOperation("Add pizzas to restaurant")
    public List<PizzaDTO> addPizzasToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS);
    
}