package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ElevatorService {

    private final ElevatorList elevatorList;
    private final ElevatorPicker elevatorPicker;

    // Have no idea what to do with moving direction
    public void pickUp(int requestFlor) {
        elevatorPicker.pick(requestFlor);
    }

    public boolean update(Elevator elevator) {
        if (updateValidator(elevator)) return false;
        var current = elevatorList.getList().get(elevator.getId() - 1);
        current.setCurrentFlor(elevator.getCurrentFlor());
        current.setDestinationFlor(elevator.getDestinationFlor());
        return true;
    }

    public void step() {
        //TODO
    }

    public List<Elevator> status() {
        return elevatorList.getList();
    }

    private boolean updateValidator(Elevator elevator) {
        return elevator.getId() > elevatorList.getList().size() || elevator.getId() < 1;
    }

}
