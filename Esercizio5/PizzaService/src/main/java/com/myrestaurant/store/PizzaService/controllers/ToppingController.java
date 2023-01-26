package com.myrestaurant.store.PizzaService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurant.store.PizzaService.dto.ToppingDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Topping API")
public interface ToppingController {

    @ApiOperation("Add new topping")
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO);

    @ApiOperation("Find topping by ID")
    public ToppingDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete topping by ID")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all toppings")
    public List<ToppingDTO> list();

    @ApiOperation("Update topping")
    public ToppingDTO update(@RequestBody ToppingDTO toppingDTO, @PathVariable("id") Long id);

}
