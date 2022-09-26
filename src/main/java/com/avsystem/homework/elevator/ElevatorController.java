package com.avsystem.homework.elevator;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ElevatorController {

    private final ElevatorService elevatorService;

    @GetMapping("/elevators")
    public List<Elevator> getElevators() {
        return elevatorService.status();
    }

    @PutMapping("/elevator")
    public ResponseEntity<String> update(
            @RequestBody Elevator elevator
    ) {
        if (elevatorService.update(elevator.getId(), elevator.getCurrentFlor(), elevator.getDestinationFlor())) {
            return new ResponseEntity<>(
                    "Elevator added!!",
                    HttpStatus.CREATED
            );
        } else {
            return new ResponseEntity<>(
                    "Couldn't add the elevator!! Wrong data!!",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
