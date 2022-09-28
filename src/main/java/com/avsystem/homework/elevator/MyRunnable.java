package com.avsystem.homework.elevator;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class MyRunnable implements Runnable {

    private final Map<Integer, List<Integer>> queueMap;

    MyRunnable(Map<Integer, List<Integer>> queueMap) {
        this.queueMap = queueMap;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } catch (Exception exception) {
            throw new RuntimeException("Threads!!!!!!");
        }
    }
}