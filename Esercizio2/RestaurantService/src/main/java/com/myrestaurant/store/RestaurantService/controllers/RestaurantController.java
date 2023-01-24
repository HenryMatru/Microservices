package com.myrestaurant.store.RestaurantService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurant.store.RestaurantService.dto.RestaurantDTO;

import java.util.List;

@Api(tags = "Restaurant API")
public interface RestaurantController {
	
	@ApiOperation("Add new Restaurant")
    RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO);

    @ApiOperation("Find Restaurant by ID")
    RestaurantDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete Restaurant by ID")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all Restaurants")
    List<RestaurantDTO> list();

    @ApiOperation("Update Restaurant")
    RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Long id);
    
    @ApiOperation("Find alla pizzas by restaurant ID")
	public List<Object> getPizzaByRestaurantId(@PathVariable("id") Long id);

}
