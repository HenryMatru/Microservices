package com.myrestaurantservice.PizzaRestaurantService.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurantservice.PizzaRestaurantService.dao.DriverRepository;
import com.myrestaurantservice.PizzaRestaurantService.models.Driver;
import com.myrestaurantservice.PizzaRestaurantService.services.DriverService;

import lombok.RequiredArgsConstructor;

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
		return (List<Driver>) this.driverRepository.saveAll(entities);
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
		return (List<Driver>) this.driverRepository.findAll();
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
