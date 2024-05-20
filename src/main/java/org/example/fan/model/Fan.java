package org.example.fan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Fan {
    private int speed;
    private boolean isClockwise;
    private boolean isOn;

    /**
     * Constructs a new Fan object with default settings.
     * The initial speed is set to 0, the direction is clockwise, and the state is off.
     */
    public Fan() {
        this.speed = 0;
        this.isClockwise = true;
        this.isOn = false;
    }

    /**
     * Returns the current speed of the fan.
     *
     * @return the current speed of the fan
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Increases the speed of the fan by pulling the speed cord.
     * If the current speed is less than 3, it increments the speed by 1.
     * If the current speed is 3, it resets the speed to 0.
     */
    public void pullSpeedCord() {
        if (speed < 3) {
            speed++;
        } else {
            speed = 0;
        }
    }

    /**
     * Reverses the direction of the fan by pulling the direction cord.
     * If the current direction is clockwise, it changes to counterclockwise, and vice versa.
     */
    public void pullDirectionCord() {
        isClockwise = !isClockwise;
    }

    /**
     * Returns the current direction of the fan.
     *
     * @return true if the fan is rotating clockwise, false otherwise
     */
    @JsonProperty("isClockwise")
    public boolean isClockwise() {
        return isClockwise;
    }

    /**
     * Returns the current state of the fan.
     *
     * @return true if the fan is on, false otherwise
     */
    @JsonProperty("isOn")
    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
