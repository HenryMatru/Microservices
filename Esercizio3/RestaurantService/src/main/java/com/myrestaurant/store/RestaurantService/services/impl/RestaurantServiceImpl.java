package com.myrestaurant.store.RestaurantService.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurant.store.RestaurantService.dao.RestaurantRepository;
import com.myrestaurant.store.RestaurantService.models.Restaurant;
import com.myrestaurant.store.RestaurantService.services.RestaurantService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant save(Restaurant entity) {
        return this.restaurantRepository.save(entity);
    }

    @Override
    public List<Restaurant> save(List<Restaurant> entities) {
        return this.restaurantRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
    	this.restaurantRepository.deleteById(id);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> findAll() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant update(Restaurant entity, Long id) {
        Optional<Restaurant> optional = this.findById(id);
        if (optional.isPresent()) {
            return this.save(entity);
        }
        return null;
    }
    
}
