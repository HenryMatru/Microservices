package com.myrestaurant.store.PizzaService.mappers;

import com.myrestaurant.store.PizzaService.dto.RestaurantIdsDTO;
import com.myrestaurant.store.PizzaService.models.RestaurantIds;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-26T11:51:38+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class RestaurantIdsMapperImpl implements RestaurantIdsMapper {

    @Override
    public RestaurantIds asEntity(RestaurantIdsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RestaurantIds.RestaurantIdsBuilder restaurantIds = RestaurantIds.builder();

        restaurantIds.pizzaId( dto.getPizzaId() );
        restaurantIds.restaurantId( dto.getRestaurantId() );

        return restaurantIds.build();
    }

    @Override
    public RestaurantIdsDTO asDTO(RestaurantIds entity) {
        if ( entity == null ) {
            return null;
        }

        RestaurantIdsDTO.RestaurantIdsDTOBuilder restaurantIdsDTO = RestaurantIdsDTO.builder();

        restaurantIdsDTO.pizzaId( entity.getPizzaId() );
        restaurantIdsDTO.restaurantId( entity.getRestaurantId() );

        return restaurantIdsDTO.build();
    }

    @Override
    public List<RestaurantIds> asEntityList(List<RestaurantIdsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RestaurantIds> list = new ArrayList<RestaurantIds>( dtoList.size() );
        for ( RestaurantIdsDTO restaurantIdsDTO : dtoList ) {
            list.add( asEntity( restaurantIdsDTO ) );
        }

        return list;
    }

    @Override
    public List<RestaurantIdsDTO> asDTOList(List<RestaurantIds> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RestaurantIdsDTO> list = new ArrayList<RestaurantIdsDTO>( entityList.size() );
        for ( RestaurantIds restaurantIds : entityList ) {
            list.add( asDTO( restaurantIds ) );
        }

        return list;
    }
}
