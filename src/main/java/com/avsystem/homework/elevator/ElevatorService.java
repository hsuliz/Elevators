package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ElevatorService {

    private final ElevatorList elevatorList;
    private final ElevatorPicker elevatorPicker;

    public void pickUp(int requestFlor) {
        elevatorPicker.pick(requestFlor);
    }

    public boolean update(Elevator elevator) {
        if (updateValidator(elevator)) return false;
        elevatorUpdater(elevator);
        return true;
    }

    public void step() {
        var updateMap = elevatorPicker.run();
        var indexes = updateMap.keySet().stream().toList();
        System.out.println(updateMap);
        for (Integer index : indexes) {
            if (updateMap.get(index) != null) {
                elevatorList.getList().get(index - 1).setCurrentFlor(updateMap.get(index));
            }
        }
    }

    public List<Elevator> status() {
        return elevatorList.getList();
    }

    private boolean updateValidator(Elevator elevator) {
        return elevator.getId() > elevatorList.getList().size() || elevator.getId() < 1;
    }

    private void elevatorUpdater(Elevator elevator) {
        var current = elevatorList.getList().get(elevator.getId() - 1);
        current.setCurrentFlor(elevator.getCurrentFlor());
        current.setDestinationFlor(elevator.getDestinationFlor());
    }

}
