package com.avsystem.homework.elevator;


import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;

public class MyRunnable implements Callable<Integer> {

    private final Map<Integer, Queue<Integer>> queueMap;
    private final int id;

    MyRunnable(Map<Integer, Queue<Integer>> queueMap, int id) {
        this.queueMap = queueMap;
        this.id = id;
    }

    @Override
    public Integer call() {
        try {
            Integer poll = queueMap.get(id).poll();
            if (poll != null) {
                return poll;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException("Threads!!!!!!");
        }
        return null;
    }

}