package com.example.elevator_system.junits;
import com.example.elevator_system.model.Elevator;
import com.example.elevator_system.service.ElevatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tests {
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
}
