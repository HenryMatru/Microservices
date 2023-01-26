package com.myrestaurant.store.RestaurantService.controllers.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.myrestaurant.store.RestaurantService.controllers.RestaurantController;
import com.myrestaurant.store.RestaurantService.dto.RestaurantDTO;
import com.myrestaurant.store.RestaurantService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.RestaurantService.mappers.RestaurantMapper;
import com.myrestaurant.store.RestaurantService.services.RestaurantService;

import com.myrestaurant.store.RestaurantService.models.Restaurant;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {

    private final RestaurantService restaurantService;

    private final RestaurantMapper restaurantMapper;
    
    private final RabbitTemplate rabbitTemplate;
    
    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;
    
    @Value("${app.rabbitmq.add-pizzas-routingkey}")
    private String addPizzasToRestaurantRoutingKey;

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

	@Override
	@GetMapping("/pizzas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Object> getPizzaByRestaurantId(@PathVariable("id") Long id) {
		RestTemplate restTemplate = new RestTemplate();
		List<Object> result = List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + id, Object[].class)));
		this.rabbitTemplate.convertAndSend("", this.addPizzasToRestaurantRoutingKey, "Added no. " + result.size() + " pizzas");
		return result;
	}
	
	/*
	@Override
	@PostMapping("/addPizzas")
	@ResponseStatus(HttpStatus.CREATED)
    public List<Object> addPizzasRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS) {
    	RestTemplate restTemplate = new RestTemplate();
    	List<Object> result = List.of(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS, Object[].class));
		this.rabbitTemplate.convertAndSend("", this.routingKey, "Added no. " + result.size() + " pizzas");
    	return result;
    }
	*/
	
	@Override
	@PostMapping("/addPizzas")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Object> addPizzasRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
		this.restaurantService.addPizzasToRestaurant(restaurantIdsDTOS);
	    return null;
	}
    

}
