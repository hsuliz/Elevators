package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ElevatorService {

    private final ElevatorList elevatorList;

    public void pickUp(int requestFlor, int movingDirection) {

    }

    public Boolean update(Elevator elevator) {
        if (elevator.getId() > 16 || elevator.getId() < 1) {
            return false;
        }
        var current = elevatorList.getList().get(elevator.getId() - 1);
        current.setCurrentFlor(elevator.getCurrentFlor());
        current.setDestinationFlor(elevator.getDestinationFlor());
        return true;
    }

    public void step() {

    }

    public List<Elevator> status() {
        return elevatorList.getList();
    }
}
