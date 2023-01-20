package com.myrestaurantservice.PizzaRestaurantService.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	private Set<Topping> toppings = new HashSet<>();
	
}
