package org.example.fan.service;

import org.example.fan.model.Fan;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class FanService {
    private Fan fan;

    private static final int DAYOFF = 25;
    private static final int MONTHOFF = 12;

    public FanService() {
        this.fan = new Fan();
    }

    /**
     * Getter method to retrieve the fan object.
     *
     * @return The fan object.
     */
    public Fan getFan() {
        return fan;
    }

    /**
     * Method to pull the speed cord of the fan.
     * Increases the speed of the fan and sets the fan state based on the current speed and date.
     * If the current date is the "off" date, the fan is turned off regardless of the speed.
     *
     * @throws IllegalStateException if an error occurs while pulling the speed cord.
     */
    public void pullSpeedCord() {
        try {
            fan.pullSpeedCord();
            if (fan.getSpeed() > 0 && !isDateOff())
                fan.setOn(true);
            if (fan.getSpeed() == 0 || isDateOff())
                fan.setOn(false);
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred while pulling the speed cord", e);
        }
    }

    /**
     * Method to pull the direction cord of the fan.
     * Reverses the direction of the fan.
     *
     * @throws IllegalStateException if an error occurs while pulling the direction cord.
     */
    public void pullDirectionCord() {
        try {
            fan.pullDirectionCord();
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred while pulling the direction cord", e);
        }
    }

    /**
     * Method to turn off the fan on the "off" date.
     * If the current date is the "off" date, the fan is turned off.
     *
     * @throws IllegalStateException if an error occurs while turning off the fan.
     */
    public void turnOffFan() {
        try {
            if (isDateOff()) {
                fan.setOn(false);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred while turning off the fan", e);
        }
    }

    /**
     * Helper method to check if the current date is the "off" date.
     *
     * @return true if the current date is the "off" date, false otherwise.
     */
    private boolean isDateOff() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getMonthValue() == MONTHOFF && currentDate.getDayOfMonth() == DAYOFF;
    }
}
