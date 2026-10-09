package com.example.elevator_system.junits;
import com.example.elevator_system.model.Elevator;
import com.example.elevator_system.service.ElevatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.elevator_system.exception.OverweightException;

public class ElevatorServiceTest {
    private ElevatorService elevatorService;
    @BeforeEach
    void setup(){
        elevatorService = new ElevatorService();
    }

    @Test
    void invalidfloor(){
        Elevator elevator=elevatorService.requestElevator(1,15);
        assertNull(elevator);
    }
    @Test
    void Requesttest() {
        Elevator elevator = elevatorService.requestElevator(1, 4);
        assertNotNull(elevator);
        assertEquals(4, elevator.getCurrentFloor());
    }
    @Test
    void goToFloorTest() {
        Elevator elevator = elevatorService.goToFloor(2, 7);
        assertNotNull(elevator);
        assertEquals(2, elevator.getId());
        assertEquals(7, elevator.getCurrentFloor());
    }
    @Test
    void weightTest() {
        Elevator elevator = elevatorService.changeCurrentWeight(3, 250);
        assertNotNull(elevator);
        assertEquals(3, elevator.getId());
        assertEquals(250, elevator.getCurrentWeight());
    }
    @Test
    void overweightTest() {
        assertThrows(
                OverweightException.class,
                () -> elevatorService.changeCurrentWeight(1, 600)
        );
    }
    @Test
    void sameFloorTest() {
        Elevator elevator = elevatorService.goToFloor(1, 0);
        assertNotNull(elevator);
        assertEquals(0, elevator.getCurrentFloor());
        assertEquals(0, elevator.getDirection());
    }
    @Test
    void closestElevator() {
        Elevator elevator1 = elevatorService.getElevator(1);
        Elevator elevator2 = elevatorService.getElevator(2);
        Elevator elevator3 = elevatorService.getElevator(3);
        elevator1.setFloorId(1);
        elevator2.setFloorId(6);
        elevator3.setFloorId(8);
        Elevator selectedElevator = elevatorService.requestElevator(1, 5);
        assertNotNull(selectedElevator);
        assertEquals(2, selectedElevator.getId());
    }
    @Test
    void avoidMoving() {
        Elevator elevator1 = elevatorService.getElevator(1);
        Elevator elevator2 = elevatorService.getElevator(2);
        Elevator elevator3 = elevatorService.getElevator(3);
        elevator1.setFloorId(1);
        elevator2.setFloorId(4);
        elevator3.setFloorId(8);
        elevator2.setMovingDirection(1);
        Elevator selectedElevator = elevatorService.requestElevator(1, 5);
        assertNotNull(selectedElevator);
        assertEquals(3, selectedElevator.getId());
    }
    @Test
    void ElevatorsMovingtest() {
        Elevator elevator1 = elevatorService.getElevator(1);
        Elevator elevator2 = elevatorService.getElevator(2);
        Elevator elevator3 = elevatorService.getElevator(3);
        elevator1.setMovingDirection(1);
        elevator2.setMovingDirection(-1);
        elevator3.setMovingDirection(1);
        Elevator selectedElevator = elevatorService.requestElevator(1, 5);
        assertNull(selectedElevator);
    }
}
