package com.example.elevator_system.controller;
import com.example.elevator_system.model.Elevator;
import com.example.elevator_system.service.ElevatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/elevator")
public class ElevatorController {
    private final ElevatorService elevatorService;
    public ElevatorController(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }
    @PostMapping("/request")
    public ResponseEntity<?> requestElevator(@RequestParam int direction, @RequestParam int floorId) {
        Elevator elevator = elevatorService.requestElevator(direction, floorId);
        if (elevator == null) {
            return ResponseEntity.badRequest().body("Invalid floor or no idle elevator available");
        }
        return ResponseEntity.ok(elevator);
    }

    @PostMapping("/gotofloor")
    public ResponseEntity<?> goToFloor(@RequestParam int elevatorId, @RequestParam int floorId) {
        Elevator elevator = elevatorService.goToFloor(elevatorId, floorId);
        if (elevator == null) {
            return ResponseEntity.badRequest().body("Invalid elevator or floor");
        }
        return ResponseEntity.ok(elevator);
    }
    @PostMapping("/weight")
    public ResponseEntity<?> changeWeight(@RequestParam int elevatorId, @RequestParam int currentWeight) {
        Elevator elevator = elevatorService.changeCurrentWeight(elevatorId, currentWeight);
        if (elevator == null) {
            return ResponseEntity.badRequest().body("Invalid elevator or maximum weight exceeded");
        }
        return ResponseEntity.ok(elevator);
    }
    @GetMapping("/all")
    public List<Elevator> getAllElevators() {
        return elevatorService.getAllElevators();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getElevator(@PathVariable int id) {
        Elevator elevator = elevatorService.getElevator(id);

        if (elevator == null) {
            return ResponseEntity.badRequest().body("Elevator not found");
        }
        return ResponseEntity.ok(elevator);
    }
}