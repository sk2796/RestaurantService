package com.project.restaurantlisting.controller;

import com.project.restaurantlisting.dto.RestaurantDto;
import com.project.restaurantlisting.model.Restaurant;
import com.project.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable int id) {
        RestaurantDto restaurantById = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurantById);
    }
    
    @PostMapping("/addrestaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.addRestaurant(restaurantDto);
        return new ResponseEntity<>("Restaurant added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/fetchallrestaurants")
    public List<RestaurantDto> fetchAllRestaurants() {
        return ResponseEntity.ok(restaurantService.fetchAllRestaurants()).getBody();
    }
}
