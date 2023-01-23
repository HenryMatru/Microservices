package com.myrestaurantservice.PizzaRestaurantService.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name="restaurants")
public class Restaurant implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Long id;
	
	@NotBlank
	@Size(max = 255)
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Size(max = 255)
	@Column(name="address")
	private String address;
	
	@NotBlank
	@Size(max = 255)
	@Column(name ="city")
	private String city;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "restaurants_drivers",
			joinColumns=@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id"),
            inverseJoinColumns=@JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
	)
	@JsonIgnore
	private Set<Driver> drivers = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "restaurants_pizzas",
			joinColumns=@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id"),
            inverseJoinColumns=@JoinColumn(name = "pizza_id", referencedColumnName = "pizza_id")
	)
	@JsonIgnore
	private Set<Pizza> pizzas = new HashSet<>();
	
}
