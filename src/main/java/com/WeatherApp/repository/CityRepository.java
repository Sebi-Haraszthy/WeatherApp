package com.WeatherApp.repository;

import com.WeatherApp.model.City;
import com.WeatherApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByUserListContaining(User user);
}