package com.example.elevator_system.model;

public class Elevator implements ElevatorFactory {

    private int id;
    private String name;
    private int floorId;
    private int movingDirection;
    private int currentWeight;

    public Elevator(int id, String name, int floorId) {
        this.id = id;
        this.name = name;
        this.floorId = floorId;
        this.movingDirection = 0;
        this.currentWeight = 0;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCurrentFloor() {
        return floorId;
    }

    @Override
    public int getDirection() {
        return movingDirection;
    }

    @Override
    public int getCurrentWeight() {
        return currentWeight;
    }

    public String getName() {
        return name;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public void setMovingDirection(int movingDirection) {
        this.movingDirection = movingDirection;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}