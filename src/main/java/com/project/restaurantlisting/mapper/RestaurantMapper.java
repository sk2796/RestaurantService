package com.project.restaurantlisting.mapper;

import com.project.restaurantlisting.dto.RestaurantDto;
import com.project.restaurantlisting.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);

    RestaurantDto toRestaurantDto(Restaurant restaurant);

}
