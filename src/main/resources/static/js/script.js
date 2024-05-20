
function getFanState() {
    fetch('/fan/state')
        .then(response => response.json())
        .then(data => {

            const fanState = document.getElementById('fanState');
            const currentDate = new Date().toLocaleDateString();

            fanState.innerHTML = `The fan is <strong>${data.isOn ? 'on' : 'off'}</strong>.<br>
                                  Speed: ${data.speed}<br>
                                  Direction: ${data.isClockwise ? 'Clockwise' : 'Counterclockwise'}<br>
                                  Date: ${currentDate}`;
        });
}

/**
 * Sends a request to the server to pull the speed cord of the fan.
 * Updates the fan state after the request is completed.
 */
function pullSpeedCord() {
    fetch('/fan/speed', {method: 'POST'})
        .then(() => getFanState());
}

/**
 * Sends a request to the server to pull the direction cord of the fan.
 * Updates the fan state after the request is completed.
 */
function pullDirectionCord() {
    fetch('/fan/direction', {method: 'POST'})
        .then(() => getFanState());
}

document.addEventListener('DOMContentLoaded', getFanState);