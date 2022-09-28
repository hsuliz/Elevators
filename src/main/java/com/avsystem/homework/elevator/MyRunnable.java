package com.avsystem.homework.elevator;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Queue;

@Slf4j
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
            System.out.println(queueMap.get(id));
        } catch (Exception exception) {
            throw new RuntimeException("Threads!!!!!!");
        }
    }
}