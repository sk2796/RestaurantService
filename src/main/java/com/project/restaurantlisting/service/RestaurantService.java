package com.project.restaurantlisting.service;

import com.project.restaurantlisting.dto.RestaurantDto;
import com.project.restaurantlisting.mapper.RestaurantMapper;
import com.project.restaurantlisting.model.Restaurant;
import com.project.restaurantlisting.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;
    public RestaurantDto getRestaurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        return Optional.ofNullable(RestaurantMapper.INSTANCE.toRestaurantDto(restaurant.get())).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public List<RestaurantDto> fetchAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepo.findAll();
        return restaurantList.stream().map(RestaurantMapper.INSTANCE::toRestaurantDto).toList();
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto) {
        restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto));
        return restaurantDto;
    }
}
