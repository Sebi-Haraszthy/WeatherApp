package com.WeatherApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "userList", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnoreProperties("userList")
    private List<City> cityList;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCityList() {
        if (this.cityList == null) {
            this.cityList = new ArrayList<>();
        }

        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "User: " + "id = " + id + "; name = " + name + "; cityList = " + cityList + ".";
    }
}