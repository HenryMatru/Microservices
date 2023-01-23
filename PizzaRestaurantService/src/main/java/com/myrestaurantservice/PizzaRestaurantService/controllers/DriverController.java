package com.myrestaurantservice.PizzaRestaurantService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurantservice.PizzaRestaurantService.dto.DriverDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "driver API")
public interface DriverController {
	
	@ApiOperation("Add new driver")
	public DriverDTO save(@RequestBody DriverDTO driverDTO);
	
	@ApiOperation("Find driver by ID")
	public DriverDTO findById(@PathVariable("id") Long id);
	
	@ApiOperation("Delete driver by ID")
	public void delete(@PathVariable("id") Long id);
	
	@ApiOperation("Find all drivers")
	public List<DriverDTO> list();
	
	@ApiOperation("Update driver")
	public DriverDTO update(@RequestBody DriverDTO driverDTO, @PathVariable("id") Long id);
	
}
