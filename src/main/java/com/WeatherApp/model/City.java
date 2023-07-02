package com.WeatherApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "user_city", joinColumns = @JoinColumn(name = "city_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties("cityList")
    private List<User> userList;

    public City() {
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

    public List<User> getUserList() {
        if (this.userList == null) {
            this.userList = new ArrayList<>();
        }

        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "City: " + "id = " + id + "; name = " + name + "; userList = " + userList + ".";
    }
}