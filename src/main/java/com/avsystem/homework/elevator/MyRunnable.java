package com.avsystem.homework.elevator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRunnable implements Runnable {

    private int size = 0;

    MyRunnable(int size) {
        this.size = size;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < size; i++) {
                
            }
        } catch (Exception exception) {
            throw new RuntimeException("Threads!!!!!!");
        }
    }
}