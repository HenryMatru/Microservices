package com.myrestaurantservice.PizzaRestaurantService.mapper;

import com.myrestaurantservice.PizzaRestaurantService.dto.ToppingDTO;
import com.myrestaurantservice.PizzaRestaurantService.models.Topping;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-23T11:02:35+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20220802-0458, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class ToppingMapperImpl implements ToppingMapper {

    @Override
    public ToppingDTO asDTO(Topping entity) {
        if ( entity == null ) {
            return null;
        }

        ToppingDTO.ToppingDTOBuilder toppingDTO = ToppingDTO.builder();

        toppingDTO.id( entity.getId() );
        toppingDTO.name( entity.getName() );

        return toppingDTO.build();
    }

    @Override
    public List<ToppingDTO> asDTOList(List<Topping> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ToppingDTO> list = new ArrayList<ToppingDTO>( entityList.size() );
        for ( Topping topping : entityList ) {
            list.add( asDTO( topping ) );
        }

        return list;
    }

    @Override
    public Topping asEntity(ToppingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Topping.ToppingBuilder topping = Topping.builder();

        topping.id( dto.getId() );
        topping.name( dto.getName() );

        return topping.build();
    }

    @Override
    public List<Topping> asEntityList(List<ToppingDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Topping> list = new ArrayList<Topping>( dtoList.size() );
        for ( ToppingDTO toppingDTO : dtoList ) {
            list.add( asEntity( toppingDTO ) );
        }

        return list;
    }
}
