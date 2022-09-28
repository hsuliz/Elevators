package com.avsystem.homework.elevator;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Service
public class ElevatorPicker {

    private final ElevatorList elevatorList;

    private final Map<Integer, Queue<Integer>> queueMap;

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
        System.out.println(queueMap);
    }

    private void queueAdder(int key, int value) {
        if (!queueMap.containsKey(key)) {
            queueMap.put(key, new LinkedList<>());
        }
        queueMap.get(key).add(value);
    }

}
