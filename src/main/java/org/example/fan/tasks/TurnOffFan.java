package org.example.fan.tasks;

import org.example.fan.service.FanService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

/**
 * Component responsible for scheduling the task to turn off the fan on a specific date.
 */
@Component
public class TurnOffFan {
    private final FanService fanService;

    public TurnOffFan(FanService fanService) {
        this.fanService = fanService;
    }

    /**
     * Scheduled task to turn off the fan.
     * Runs every day at midnight (00:00:00) based on the cron expression.
     *
     * @throws IllegalStateException if an error occurs while turning off the fan in the scheduled task.
     */
    @Scheduled(cron = "0 0 0 * * ?")
//    @Scheduled(cron = "0 * * * * ?")
    public void turnOffFan() {
        try {
            fanService.turnOffFan();
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred while turning off the fan in the scheduled task", e);
        }
    }
}
