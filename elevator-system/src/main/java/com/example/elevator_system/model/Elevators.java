package com.example.elevator_system.model;

public class Elevators {
    private int id;
    private String name;
    public Elevators(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}