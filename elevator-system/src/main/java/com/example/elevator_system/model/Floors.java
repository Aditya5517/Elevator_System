package com.example.elevator_system.model;

public class Floors {
    private int id;
    private String name;
    private int number;
    public Floors(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}