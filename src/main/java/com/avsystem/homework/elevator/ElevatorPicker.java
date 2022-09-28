package com.avsystem.homework.elevator;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ElevatorPicker {

    final Map<Integer, Queue<Integer>> queueMap;
    private final ElevatorList elevatorList;

    public ElevatorPicker(ElevatorList elevatorList) {
        this.elevatorList = elevatorList;
        this.queueMap = new HashMap<>();
    }


    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        var indexes = queueMap.keySet().stream().toList();
        try {
            indexes.forEach(integer -> executor.execute(new MyRunnable(queueMap, integer)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        executor.shutdown();
    }

    public void pick(int requestFlor) {
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
