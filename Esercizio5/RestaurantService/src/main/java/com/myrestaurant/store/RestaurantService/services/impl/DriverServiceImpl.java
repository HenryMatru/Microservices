package com.myrestaurant.store.RestaurantService.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurant.store.RestaurantService.dao.DriverRepository;
import com.myrestaurant.store.RestaurantService.models.Driver;
import com.myrestaurant.store.RestaurantService.services.DriverService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public Driver save(Driver entity) {
        return this.driverRepository.save(entity);
    }

    @Override
    public List<Driver> save(List<Driver> entities) {
        return this.driverRepository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
    	this.driverRepository.deleteById(id);
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return this.driverRepository.findById(id);
    }

    @Override
    public List<Driver> findAll() {
        return this.driverRepository.findAll();
    }

    @Override
    public Driver update(Driver entity, Long id) {
        Optional<Driver> optional = this.findById(id);
        if (optional.isPresent()) {
            return this.save(entity);
        }
        return null;
    }

}
