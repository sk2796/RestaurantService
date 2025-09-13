package com.project.restaurantlisting.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
