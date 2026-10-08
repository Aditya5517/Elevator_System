# Elevator Management System

A simple Spring Boot backend project that simulates an elevator management system for a building with 3 elevators and floors from 0 to 9.

The main focus of this project is on elevator logic, API handling, and JUnit testing.

## Features

- Manage 3 elevators
- Request an elevator from a floor
- Move a selected elevator to a destination floor
- Update elevator current weight
- Maximum weight validation
- Get all elevators
- Get a specific elevator by ID
- Select the nearest idle elevator
- Skip elevators that are already moving
- Validate invalid floor requests

## Elevator Direction

The elevator direction is represented using integers:

```text
1  = UP
-1 = DOWN
0  = IDLE
