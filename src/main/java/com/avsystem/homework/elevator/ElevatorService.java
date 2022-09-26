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
        if (validator(elevator)) return false;
        var current = elevatorList.getList().get(elevator.getId() - 1);
        current.setCurrentFlor(elevator.getCurrentFlor());
        current.setDestinationFlor(elevator.getDestinationFlor());
        return true;
    }

    private boolean validator(Elevator elevator) {
        return elevator.getId() > elevatorList.getQuantity() || elevator.getId() < 1;
    }

    public void step() {

    }

    public List<Elevator> status() {
        return elevatorList.getList();
    }

}
