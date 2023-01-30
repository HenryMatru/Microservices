package com.myrestaurant.store.RestaurantService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.myrestaurant.store.RestaurantService.dto.DriverDTO;

import java.util.List;

@Api(tags = "Driver API")
public interface DriverController {

    @ApiOperation("Add new Driver")
    public DriverDTO save(@RequestBody DriverDTO driverDTO);

    @ApiOperation("Find Driver by ID")
    public DriverDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete Driver by ID")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all Drivers")
    public List<DriverDTO> list();

    @ApiOperation("Update Driver")
    public DriverDTO update(@PathVariable("id") Long id, @RequestBody DriverDTO driverDTO);

}