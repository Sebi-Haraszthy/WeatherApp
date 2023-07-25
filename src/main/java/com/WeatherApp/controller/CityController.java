package com.WeatherApp.controller;

import com.WeatherApp.model.City;
import com.WeatherApp.model.User;
import com.WeatherApp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add/{user_id}")
    public User addCity(@RequestBody City city, @PathVariable Long user_id) {
        return cityService.addCity(city, user_id);
    }

    @DeleteMapping("/delete/{user_id}/{city_id}")
    public User deleteCity(@PathVariable Long city_id, @PathVariable Long user_id) {
        return cityService.deleteCity(city_id, user_id);
    }

    @GetMapping("/{user_id}")
    public List<City> getUserFavoriteCities(@PathVariable Long user_id) {
        return cityService.getUserFavoriteCities(user_id);
    }
}