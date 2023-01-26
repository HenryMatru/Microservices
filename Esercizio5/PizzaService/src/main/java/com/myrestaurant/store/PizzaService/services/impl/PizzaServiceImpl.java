package com.myrestaurant.store.PizzaService.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myrestaurant.store.PizzaService.dao.PizzaRepository;
import com.myrestaurant.store.PizzaService.dao.RestaurantIdsRepository;
import com.myrestaurant.store.PizzaService.models.Pizza;
import com.myrestaurant.store.PizzaService.models.RestaurantIds;
import com.myrestaurant.store.PizzaService.services.PizzaService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {
	
	private final PizzaRepository pizzaRepository;
	
	private final RestaurantIdsRepository restaurantIdsRepository;
	
	private final RabbitTemplate rabbitTemplate;
	
	@Value("${app.rabbitmq.pizzas-added-routingkey}")
    private String pizzasToRestaurantAddRoutingKey;
	
	@Value("${app.rabbitmq.notify-pizzas-added-routingkey}")
    private String notifyPizzasToRestaurantAddRoutingKey;
	
	@Override
    public Pizza save(Pizza entity) {
        return this.pizzaRepository.save(entity);
    }

    @Override
    public List<Pizza> save(List<Pizza> entities) {
        return this.pizzaRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
    	this.pizzaRepository.deleteById(id);
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return this.pizzaRepository.findById(id);
    }

    @Override
    public List<Pizza> findAll() {
        return this.pizzaRepository.findAll();
    }

    @Override
    public Pizza update(Pizza entity, Long id) {
        Optional<Pizza> optional = this.findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

	@Override
	public List<Pizza> findByRestaurantId(Long restaurantId) {
		List<RestaurantIds> restaurantIds = this.restaurantIdsRepository.findByRestaurantId(restaurantId);
		List<Pizza> pizzas = new ArrayList<>(restaurantIds.size());
		for (RestaurantIds el : restaurantIds) {
			pizzas.add(this.pizzaRepository.findById(el.getPizzaId()).get());
		}
		return pizzas;
	}
	
	@Override
	public List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds) {
		List<Pizza> pizzas = new ArrayList<>();
		for (RestaurantIds el : restaurantIds) {
			pizzas.add(this.pizzaRepository.findById(el.getPizzaId()).get());
		}
		this.restaurantIdsRepository.saveAll(restaurantIds);
		this.rabbitTemplate.convertAndSend("", pizzasToRestaurantAddRoutingKey, pizzas);
		String message = "Added n. " + pizzas.size() + " pizzas.";
		this.rabbitTemplate.convertAndSend("", this.notifyPizzasToRestaurantAddRoutingKey, message);
		return pizzas;
	}

}
