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

import com.myrestaurantservice.PizzaRestaurantService.controllers.ToppingController;
import com.myrestaurantservice.PizzaRestaurantService.dto.ToppingDTO;
import com.myrestaurantservice.PizzaRestaurantService.mapper.ToppingMapper;
import com.myrestaurantservice.PizzaRestaurantService.models.Topping;
import com.myrestaurantservice.PizzaRestaurantService.services.ToppingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/toppings")
@RequiredArgsConstructor
public class ToppingControllerImpl implements ToppingController {

	private final ToppingService toppingService;
	
	private final ToppingMapper toppingMapper;
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ToppingDTO save(@RequestBody ToppingDTO toppingDTO) {
		Topping topping = this.toppingMapper.asEntity(toppingDTO);
		return this.toppingMapper.asDTO(this.toppingService.save(topping));
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ToppingDTO findById(@PathVariable("/{id}") Long id) {
		Topping topping = this.toppingService.findById(id).orElse(null);
		return this.toppingMapper.asDTO(topping);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("/{id}") Long id) {
		this.toppingService.deleteById(id);
	}

	@Override
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ToppingDTO> list() {
		return this.toppingMapper.asDTOList(this.toppingService.findAll());
	}

	@Override
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ToppingDTO update(@RequestBody ToppingDTO toppingDTO, @PathVariable("/{id}") Long id) {
		Topping topping = this.toppingMapper.asEntity(toppingDTO);
		return this.toppingMapper.asDTO(this.toppingService.update(topping, id));
	}

}
