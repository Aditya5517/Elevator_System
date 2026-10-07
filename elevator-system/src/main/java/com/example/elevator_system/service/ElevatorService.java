package com.example.elevator_system.service;
import com.example.elevator_system.model.Elevator;
import org.springframework.stereotype.Service;
import java.util.PriorityQueue;
@Service
public class ElevatorService {
    private PriorityQueue<Elevator> priorityQueue;
    public ElevatorService() {
        priorityQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getId(), e2.getId()));
        priorityQueue.add(new Elevator(1, "Elevator 1", 0));
        priorityQueue.add(new Elevator(2, "Elevator 2", 0));
        priorityQueue.add(new Elevator(3, "Elevator 3", 0));
    }
    public Elevator requestElevator(int direction, int floorId) {
        if (floorId < 0 || floorId > 9) {return null;}
        Elevator selectedElevator = null;
        int minimumDistance = Integer.MAX_VALUE;
        for (Elevator elevator : priorityQueue) {
            int distance = Math.abs(elevator.getCurrentFloor() - floorId);
            if (distance < minimumDistance) {
                minimumDistance = distance;
                selectedElevator = elevator;
            }
        }
        if (selectedElevator != null) {
            selectedElevator.setMovingDirection(direction);
            selectedElevator.setFloorId(floorId);
            selectedElevator.setMovingDirection(0);
        }
        return selectedElevator;
    }
    public Elevator goToFloor(
            int elevatorId,
            int goToFloorId) {
        if (goToFloorId < 0 || goToFloorId > 9) {
            return null;
        }
        for (Elevator elevator : priorityQueue) {
            if (elevator.getId() == elevatorId) {
                int currentFloor = elevator.getCurrentFloor();
                if (goToFloorId > currentFloor) {
                    elevator.setMovingDirection(1);
                } else if (goToFloorId < currentFloor) {
                    elevator.setMovingDirection(-1);
                } else {
                    elevator.setMovingDirection(0);
                }
                elevator.setFloorId(goToFloorId);
                elevator.setMovingDirection(0);
                return elevator;
            }
        }
        return null;
    }

    public Elevator changeCurrentWeight(
            int elevatorId,
            int currentWeight) {
        for (Elevator elevator : priorityQueue) {
            if (elevator.getId() == elevatorId) {
                elevator.setCurrentWeight(currentWeight);
                return elevator;
            }
        }
        return null;
    }
    public PriorityQueue<Elevator> getPq() {
        return priorityQueue;
    }
}