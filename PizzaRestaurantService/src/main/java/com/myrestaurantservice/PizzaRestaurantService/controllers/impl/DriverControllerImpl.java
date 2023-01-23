package com.myrestaurantservice.PizzaRestaurantService.controllers.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myrestaurantservice.PizzaRestaurantService.controllers.DriverController;
import com.myrestaurantservice.PizzaRestaurantService.dto.DriverDTO;
import com.myrestaurantservice.PizzaRestaurantService.mapper.DriverMapper;
import com.myrestaurantservice.PizzaRestaurantService.models.Driver;
import com.myrestaurantservice.PizzaRestaurantService.services.DriverService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverControllerImpl implements DriverController {
	
	private final DriverService driverService;
	
	private final DriverMapper driverMapper;

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DriverDTO save(@RequestBody DriverDTO driverDTO) {
		Driver driver = this.driverMapper.asEntity(driverDTO);
		return this.driverMapper.asDTO(this.driverService.save(driver));
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DriverDTO findById(@PathVariable("id") Long id) {
		Driver driver = this.driverService.findById(id).orElse(null);
		return this.driverMapper.asDTO(driver);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.driverService.deleteById(id);
	}

	@Override
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<DriverDTO> list() {
		return this.driverMapper.asDTOList(this.driverService.findAll());
	}

	@Override
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DriverDTO update(@RequestBody DriverDTO driverDTO, @PathVariable("id")  Long id) {
		Driver driver = this.driverMapper.asEntity(driverDTO);
		return this.driverMapper.asDTO(this.driverService.update(driver, id));
	}

}
