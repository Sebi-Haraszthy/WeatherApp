package com.WeatherApp.service;

import com.WeatherApp.model.City;
import com.WeatherApp.model.User;
import com.WeatherApp.repository.CityRepository;
import com.WeatherApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CityService {
    private CityRepository cityRepository;
    private UserRepository userRepository;

    @Autowired
    public CityService(CityRepository cityRepository, UserRepository userRepository) {
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
    }

    public User addCity(City city, Long user_id) {
        User foundUser = userRepository.findById(user_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        foundUser.getCityList().add(city);
        city.getUserList().add(foundUser);

        return userRepository.save(foundUser);
    }

    public User deleteCity(Long city_id, Long user_id) {
        User foundUser = userRepository.findById(user_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        City foundCity = cityRepository.findById(city_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found!"));
        foundUser.getCityList().remove(foundCity);
        foundCity.getUserList().remove(foundUser);

        return userRepository.save(foundUser);
    }

    public List<City> getUserFavoriteCities(Long user_id) {
        User foundUser = userRepository.findById(user_id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));

        return cityRepository.findAllByUserListContaining(foundUser);
    }
}