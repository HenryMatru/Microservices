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

import com.myrestaurantservice.PizzaRestaurantService.controllers.PizzaController;
import com.myrestaurantservice.PizzaRestaurantService.dto.PizzaDTO;
import com.myrestaurantservice.PizzaRestaurantService.mapper.PizzaMapper;
import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;
import com.myrestaurantservice.PizzaRestaurantService.services.PizzaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaControllerImpl implements PizzaController {

	private final PizzaService pizzaService;
	
	private final PizzaMapper pizzaMapper;
	
	@Override
	@GetMapping("/restaurant/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<PizzaDTO> findByRestaurantsId(@PathVariable("id") Long id) {
		List<Pizza> pizzas = this.pizzaService.findByRestaurantId(id);
		return this.pizzaMapper.asDTOList(pizzas);
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
		Pizza pizza = this.pizzaMapper.asEntity(pizzaDTO);
		return this.pizzaMapper.asDTO(this.pizzaService.save(pizza));
	}

	@Override
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PizzaDTO findById(@PathVariable("id") Long id) {
		Pizza pizza = this.pizzaService.findById(id).orElse(null);
		return this.pizzaMapper.asDTO(pizza);
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.pizzaService.deleteById(id);
	}

	
	@Override
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PizzaDTO> list() {
		return this.pizzaMapper.asDTOList(this.pizzaService.findAll());
	}

	@Override
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PizzaDTO update(@RequestBody PizzaDTO pizzaDTO, @PathVariable("/{id}") Long id) {
		Pizza pizza = this.pizzaMapper.asEntity(pizzaDTO);
		return this.pizzaMapper.asDTO(this.pizzaService.update(pizza, id));
	}

}
