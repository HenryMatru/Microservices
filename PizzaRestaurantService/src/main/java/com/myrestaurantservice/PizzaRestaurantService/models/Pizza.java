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
@Table(name="pizzas")
public class Pizza implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_id")
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 255)
	@Column(name = "name")
	private String name;
	
	@Column(name = "favorite")
	private boolean favorite;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "pizzas_toppings",
			joinColumns=@JoinColumn(name = "pizza_id", referencedColumnName = "pizza_id"),
            inverseJoinColumns=@JoinColumn(name = "topping_id", referencedColumnName = "topping_id")
	)
	@JsonIgnore
	private Set<Topping> toppings = new HashSet<>();
	
	@ManyToMany(mappedBy = "pizzas")
	@JsonIgnore
	private Set<Restaurant> restaurants = new HashSet<>();
	
}
