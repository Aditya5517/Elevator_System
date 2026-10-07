package com.example.elevator_system.model;

public interface ElevatorFactory {

    int getId();

    int getCurrentFloor();

    int getDirection();

    int getCurrentWeight();
}