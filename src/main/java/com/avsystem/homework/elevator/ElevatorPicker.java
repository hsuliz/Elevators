package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ElevatorPicker {

    private final ElevatorList elevatorList;


    int pick(int requestFlor) {
        var defVal = Math.abs(elevatorList.getList().get(0).getCurrentFlor() - requestFlor);
        var id = elevatorList.getList().get(0).getId();
        for (int i = 0; i < elevatorList.getList().size(); i++) {
            if (Math.abs(elevatorList.getList().get(i).getCurrentFlor() - requestFlor) < defVal) {
                defVal = Math.abs(elevatorList.getList().get(i).getCurrentFlor() - requestFlor);
                id = elevatorList.getList().get(i).getId();
            }
        }
        return id;
    }

}
