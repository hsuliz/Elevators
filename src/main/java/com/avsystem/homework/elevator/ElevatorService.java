package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ElevatorService {

    private final ElevatorList elevatorList;
    private final ElevatorPicker elevatorPicker;

    public void pickUp(int requestFlor, int movingDirection) {
        elevatorPicker.pick(requestFlor);
    }

    public boolean update(Elevator elevator) {
        if (updateValidator(elevator)) return false;
        var current = elevatorList.getList().get(elevator.getId() - 1);
        current.setCurrentFlor(elevator.getCurrentFlor());
        current.setDestinationFlor(elevator.getDestinationFlor());
        return true;
    }

    private boolean updateValidator(Elevator elevator) {
        return elevator.getId() > elevatorList.getList().size() || elevator.getId() < 1;
    }

    public void step() {
        //TODO
    }

    public List<Elevator> status() {
        return elevatorList.getList();
    }

}
