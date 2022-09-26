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

    public void update(int id, int currentFlor, int destinationFlor) {

    }

    public void step() {

    }

    public List<Elevator> status() {
        return elevatorList.getList();
    }
}
