package com.avsystem.homework.elevator;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class ElevatorPicker {

    final Map<Integer, Queue<Integer>> queueMap;
    private final ElevatorList elevatorList;

    public ElevatorPicker(ElevatorList elevatorList) {
        this.elevatorList = elevatorList;
        this.queueMap = new HashMap<>();
    }


    public Map<Integer, Integer> run() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> futureList = new ArrayList<>();
        var indexes = queueMap.keySet().stream().toList();
        try {
            futureList = indexes.stream().map(integer -> executor.submit(new MyRunnable(queueMap, integer))).collect(Collectors.toList());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        executor.shutdown();

        Map<Integer, Integer> outMap = new HashMap<>();
        for (int i = 0; i < indexes.size(); i++) {
            try {
                outMap.put(indexes.get(i), futureList.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return outMap;
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
