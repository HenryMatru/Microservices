package com.myrestaurant.store.PizzaService.controllers.impl;

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

import com.myrestaurant.store.PizzaService.controllers.PizzaController;
import com.myrestaurant.store.PizzaService.dto.PizzaDTO;
import com.myrestaurant.store.PizzaService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.PizzaService.mappers.PizzaMapper;
import com.myrestaurant.store.PizzaService.mappers.RestaurantIdsMapper;
import com.myrestaurant.store.PizzaService.models.Pizza;
import com.myrestaurant.store.PizzaService.models.RestaurantIds;
import com.myrestaurant.store.PizzaService.services.PizzaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaControllerImpl implements PizzaController {

    private final PizzaService pizzaService;

    private final PizzaMapper pizzaMapper;
    
    private final RestaurantIdsMapper restaurantIdsMapper;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        return pizzaMapper.asDTO(pizzaService.save(pizza));
    }

    @Override
    @GetMapping("/{id}")
    public PizzaDTO findById(@PathVariable("id") Long id) {
        Pizza pizza = pizzaService.findById(id).orElse(null);
        return pizzaMapper.asDTO(pizza);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        pizzaService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PizzaDTO> list() {
        return pizzaMapper.asDTOList(pizzaService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public PizzaDTO update(@PathVariable("id") Long id, @RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        return pizzaMapper.asDTO(pizzaService.update(pizza, id));
    }

	@Override
	@GetMapping("/restaurant/{id}")
	public List<PizzaDTO> findByRestaurantId(@PathVariable("id") Long id) {
		List<Pizza> pizzas = this.pizzaService.findByRestaurantId(id);
		return this.pizzaMapper.asDTOList(pizzas);
	}
	
	@Override
	@PostMapping("/restaurant")
    public List<PizzaDTO> addPizzasToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS) {
		List<RestaurantIds> restaurantIds = this.restaurantIdsMapper.asEntityList(restaurantIdsDTOS);
		return this.pizzaMapper.asDTOList(this.pizzaService.addPizzasToRestaurant(restaurantIds));
	}

}