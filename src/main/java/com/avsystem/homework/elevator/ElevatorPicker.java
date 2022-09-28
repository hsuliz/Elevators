package com.avsystem.homework.elevator;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ElevatorPicker {

    final Map<Integer, List<Integer>> queueMap;
    private final ElevatorList elevatorList;

    public ElevatorPicker(ElevatorList elevatorList) {
        this.elevatorList = elevatorList;
        this.queueMap = new HashMap<>();
    }

    void pick(int requestFlor) {
        var id = elevatorList.getList().get(0).getId();
        var defVal = Math.abs(elevatorList.getList().get(0).getCurrentFlor() - requestFlor);
        for (int i = 0; i < elevatorList.getList().size(); i++) {
            if (Math.abs(elevatorList.getList().get(i).getCurrentFlor() - requestFlor) < defVal) {
                defVal = Math.abs(elevatorList.getList().get(i).getCurrentFlor() - requestFlor);
                id = elevatorList.getList().get(i).getId();
            }
        }
        queueAdder(id, requestFlor);
    }

    private void queueAdder(int key, int value) {
        if (!queueMap.containsKey(key)) {
            queueMap.put(key, new LinkedList<>());
        }
        queueMap.get(key).add(value);
    }

}
