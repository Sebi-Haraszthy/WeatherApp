package com.WeatherApp.DTO;

import java.time.LocalDateTime;

public class CurrentWeatherDTO {
    private String description;
    private Integer temperature;
    private Integer feelsLikeTemperature;
    private Integer windSpeed;
    private String cityName;
    private String countryName;
    private LocalDateTime date;

    public CurrentWeatherDTO(String description, Integer temperature, Integer feelsLikeTemperature, Integer windSpeed, String cityName, String countryName, LocalDateTime date) {
        this.description = description;
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.windSpeed = windSpeed;
        this.cityName = cityName;
        this.countryName = countryName;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(Integer feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}