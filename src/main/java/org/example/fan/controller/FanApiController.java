package org.example.fan.controller;

import org.example.fan.model.Fan;
import org.example.fan.service.FanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/fan")
public class FanApiController {
    private final FanService fanService;

    /**
     * Constructs a new FanApiController with the specified FanService.
     *
     * @param fanService the FanService to be used by the controller
     */
    public FanApiController(FanService fanService) {
        this.fanService = fanService;
    }

    /**
     * Retrieves the current state of the fan.
     *
     * @return a ResponseEntity containing the Fan object representing the current state
     */
    @GetMapping("/state")
    public ResponseEntity<Fan> getFanState() {
        Fan fan = fanService.getFan();
        return ResponseEntity.ok(fan);
    }

    /**
     * Pulls the speed cord of the fan to change its speed.
     */
    @PostMapping("/speed")
    public void pullSpeedCord() {
        fanService.pullSpeedCord();
    }

    /**
     * Pulls the direction cord of the fan to change its direction.
     */
    @PostMapping("/direction")
    public void pullDirectionCord() {
        fanService.pullDirectionCord();
    }
}
