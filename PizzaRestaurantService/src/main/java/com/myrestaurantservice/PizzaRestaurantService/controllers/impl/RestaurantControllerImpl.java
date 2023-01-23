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

import com.myrestaurantservice.PizzaRestaurantService.controllers.RestaurantController;
import com.myrestaurantservice.PizzaRestaurantService.dto.RestaurantDTO;
import com.myrestaurantservice.PizzaRestaurantService.mapper.RestaurantMapper;
import com.myrestaurantservice.PizzaRestaurantService.models.Restaurant;
import com.myrestaurantservice.PizzaRestaurantService.services.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {
	
	private final RestaurantService restaurantService;
	
	private final RestaurantMapper restaurantMapper;

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO) {
		Restaurant restaurant = this.restaurantMapper.asEntity(restaurantDTO);
		return this.restaurantMapper.asDTO(this.restaurantService.save(restaurant));
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RestaurantDTO findById(@PathVariable("id") Long id) {
		Restaurant restaurant = this.restaurantService.findById(id).orElse(null);
		return this.restaurantMapper.asDTO(restaurant);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.restaurantService.deleteById(id);
	}

	@Override
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<RestaurantDTO> list() {
		return this.restaurantMapper.asDTOList(this.restaurantService.findAll());
	}

	@Override
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RestaurantDTO update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Long id) {
		Restaurant restaurant = this.restaurantMapper.asEntity(restaurantDTO);
		return this.restaurantMapper.asDTO(this.restaurantService.update(restaurant, id));
	}
	
}
