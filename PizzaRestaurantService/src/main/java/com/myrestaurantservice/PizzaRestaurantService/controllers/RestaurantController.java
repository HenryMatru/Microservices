package com.myrestaurantservice.PizzaRestaurantService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurantservice.PizzaRestaurantService.dto.RestaurantDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "restaurant API")
public interface RestaurantController {
	
	@ApiOperation("Add new restaurant")
	public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO);
	
	@ApiOperation("Find restaurant by ID")
	public RestaurantDTO findById(@PathVariable("id") Long id);
	
	@ApiOperation("Delete restaurant by ID")
	public void delete(@PathVariable("id") Long id);
	
	@ApiOperation("Find all restaurants")
	public List<RestaurantDTO> list();
	
	@ApiOperation("Update restaurant")
	public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Long id);
	
}
