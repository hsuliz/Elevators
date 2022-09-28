package com.avsystem.homework.elevator;


import java.util.Map;
import java.util.Queue;

public class MyRunnable implements Runnable {

    private final Map<Integer, Queue<Integer>> queueMap;
    private final int id;


    MyRunnable(Map<Integer, Queue<Integer>> queueMap, int id) {
        this.queueMap = queueMap;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println(queueMap.get(id).poll());
            //elevatorService.update()
        } catch (Exception exception) {
            throw new RuntimeException("Threads!!!!!!");
        }
    }
}