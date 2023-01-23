package com.myrestaurantservice.PizzaRestaurantService.mapper;

import com.myrestaurantservice.PizzaRestaurantService.dto.DriverDTO;
import com.myrestaurantservice.PizzaRestaurantService.dto.PizzaDTO;
import com.myrestaurantservice.PizzaRestaurantService.dto.RestaurantDTO;
import com.myrestaurantservice.PizzaRestaurantService.dto.ToppingDTO;
import com.myrestaurantservice.PizzaRestaurantService.models.Driver;
import com.myrestaurantservice.PizzaRestaurantService.models.Pizza;
import com.myrestaurantservice.PizzaRestaurantService.models.Restaurant;
import com.myrestaurantservice.PizzaRestaurantService.models.Topping;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T17:19:49+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant asEntity(RestaurantDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Restaurant.RestaurantBuilder restaurant = Restaurant.builder();

        restaurant.address( dto.getAddress() );
        restaurant.city( dto.getCity() );
        restaurant.drivers( driverDTOSetToDriverSet( dto.getDrivers() ) );
        restaurant.id( dto.getId() );
        restaurant.name( dto.getName() );
        restaurant.pizzas( pizzaDTOSetToPizzaSet( dto.getPizzas() ) );

        return restaurant.build();
    }

    @Override
    public RestaurantDTO asDTO(Restaurant entity) {
        if ( entity == null ) {
            return null;
        }

        RestaurantDTO.RestaurantDTOBuilder restaurantDTO = RestaurantDTO.builder();

        restaurantDTO.address( entity.getAddress() );
        restaurantDTO.city( entity.getCity() );
        restaurantDTO.drivers( driverSetToDriverDTOSet( entity.getDrivers() ) );
        restaurantDTO.id( entity.getId() );
        restaurantDTO.name( entity.getName() );
        restaurantDTO.pizzas( pizzaSetToPizzaDTOSet( entity.getPizzas() ) );

        return restaurantDTO.build();
    }

    @Override
    public List<Restaurant> asEntityList(List<RestaurantDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Restaurant> list = new ArrayList<Restaurant>( dtoList.size() );
        for ( RestaurantDTO restaurantDTO : dtoList ) {
            list.add( asEntity( restaurantDTO ) );
        }

        return list;
    }

    @Override
    public List<RestaurantDTO> asDTOList(List<Restaurant> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RestaurantDTO> list = new ArrayList<RestaurantDTO>( entityList.size() );
        for ( Restaurant restaurant : entityList ) {
            list.add( asDTO( restaurant ) );
        }

        return list;
    }

    protected Driver driverDTOToDriver(DriverDTO driverDTO) {
        if ( driverDTO == null ) {
            return null;
        }

        Driver.DriverBuilder driver = Driver.builder();

        driver.id( driverDTO.getId() );
        driver.name( driverDTO.getName() );

        return driver.build();
    }

    protected Set<Driver> driverDTOSetToDriverSet(Set<DriverDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Driver> set1 = new LinkedHashSet<Driver>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DriverDTO driverDTO : set ) {
            set1.add( driverDTOToDriver( driverDTO ) );
        }

        return set1;
    }

    protected Topping toppingDTOToTopping(ToppingDTO toppingDTO) {
        if ( toppingDTO == null ) {
            return null;
        }

        Topping.ToppingBuilder topping = Topping.builder();

        topping.id( toppingDTO.getId() );
        topping.name( toppingDTO.getName() );

        return topping.build();
    }

    protected Set<Topping> toppingDTOSetToToppingSet(Set<ToppingDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Topping> set1 = new LinkedHashSet<Topping>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ToppingDTO toppingDTO : set ) {
            set1.add( toppingDTOToTopping( toppingDTO ) );
        }

        return set1;
    }

    protected Pizza pizzaDTOToPizza(PizzaDTO pizzaDTO) {
        if ( pizzaDTO == null ) {
            return null;
        }

        Pizza.PizzaBuilder pizza = Pizza.builder();

        pizza.favorite( pizzaDTO.isFavorite() );
        pizza.id( pizzaDTO.getId() );
        pizza.name( pizzaDTO.getName() );
        pizza.toppings( toppingDTOSetToToppingSet( pizzaDTO.getToppings() ) );

        return pizza.build();
    }

    protected Set<Pizza> pizzaDTOSetToPizzaSet(Set<PizzaDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Pizza> set1 = new LinkedHashSet<Pizza>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PizzaDTO pizzaDTO : set ) {
            set1.add( pizzaDTOToPizza( pizzaDTO ) );
        }

        return set1;
    }

    protected DriverDTO driverToDriverDTO(Driver driver) {
        if ( driver == null ) {
            return null;
        }

        DriverDTO.DriverDTOBuilder driverDTO = DriverDTO.builder();

        driverDTO.id( driver.getId() );
        driverDTO.name( driver.getName() );

        return driverDTO.build();
    }

    protected Set<DriverDTO> driverSetToDriverDTOSet(Set<Driver> set) {
        if ( set == null ) {
            return null;
        }

        Set<DriverDTO> set1 = new LinkedHashSet<DriverDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Driver driver : set ) {
            set1.add( driverToDriverDTO( driver ) );
        }

        return set1;
    }

    protected ToppingDTO toppingToToppingDTO(Topping topping) {
        if ( topping == null ) {
            return null;
        }

        ToppingDTO.ToppingDTOBuilder toppingDTO = ToppingDTO.builder();

        toppingDTO.id( topping.getId() );
        toppingDTO.name( topping.getName() );

        return toppingDTO.build();
    }

    protected Set<ToppingDTO> toppingSetToToppingDTOSet(Set<Topping> set) {
        if ( set == null ) {
            return null;
        }

        Set<ToppingDTO> set1 = new LinkedHashSet<ToppingDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Topping topping : set ) {
            set1.add( toppingToToppingDTO( topping ) );
        }

        return set1;
    }

    protected PizzaDTO pizzaToPizzaDTO(Pizza pizza) {
        if ( pizza == null ) {
            return null;
        }

        PizzaDTO.PizzaDTOBuilder pizzaDTO = PizzaDTO.builder();

        pizzaDTO.favorite( pizza.isFavorite() );
        pizzaDTO.id( pizza.getId() );
        pizzaDTO.name( pizza.getName() );
        pizzaDTO.toppings( toppingSetToToppingDTOSet( pizza.getToppings() ) );

        return pizzaDTO.build();
    }

    protected Set<PizzaDTO> pizzaSetToPizzaDTOSet(Set<Pizza> set) {
        if ( set == null ) {
            return null;
        }

        Set<PizzaDTO> set1 = new LinkedHashSet<PizzaDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Pizza pizza : set ) {
            set1.add( pizzaToPizzaDTO( pizza ) );
        }

        return set1;
    }
}
