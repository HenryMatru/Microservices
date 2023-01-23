package com.myrestaurantservice.PizzaRestaurantService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurantservice.PizzaRestaurantService.dto.PizzaDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "pizza API")
public interface PizzaController {
	
	@ApiOperation("Find pizzas by Restaurant ID")
	public List<PizzaDTO> findByRestaurantsId(@PathVariable("id") Long id);
	
	@ApiOperation("Add new pizza")
	public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO);
	
	@ApiOperation("Find pizza by ID")
	public PizzaDTO findById(@PathVariable("id") Long id);
	
	@ApiOperation("Delete pizza by ID")
	public void delete(@PathVariable("id") Long id);
	
	@ApiOperation("Find all pizzas")
	public List<PizzaDTO> list();
	
	@ApiOperation("Update pizza")
	public PizzaDTO update(@RequestBody PizzaDTO pizzaDTO, @PathVariable("id") Long id);

}
