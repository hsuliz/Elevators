package com.avsystem.homework.elevator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ElevatorList {

    private final List<Elevator> elevatorList = new ArrayList<>();
    @Value("${elevator.quantity}")
    private int quantity;

    @PostConstruct
    private void postConstructor() {
        for (int i = 0; i < quantity; i++) {
            var setUp = new Elevator(i + 1, 0, 0);
            elevatorList.add(setUp);
        }
        log.info("Elevator list have been initialized!!");
        log.info(getList().toString());
    }

    public List<Elevator> getList() {
        return elevatorList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
