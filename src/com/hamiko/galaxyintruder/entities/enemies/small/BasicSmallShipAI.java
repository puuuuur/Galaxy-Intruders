package com.hamiko.galaxyintruder.entities.enemies.small;

import com.hamiko.galaxyintruder.ai.Behavior;
import com.hamiko.galaxyintruder.entities.SpaceShip;

public class BasicSmallShipAI implements Behavior {

    private int fireCounter = 0;
    private int fireTime;
    private boolean isFireTimeSet;

    @Override
    public void act(SpaceShip s) {

        setFireTime();

        if (fireCounter++ >= fireTime) {

            BasicSmallShip ship = (BasicSmallShip) s;
            ship.getGun().shootWeapon(ship);

            fireCounter = 0;
            isFireTimeSet = false;

        }

    }

    private void setFireTime() {

        if (isFireTimeSet) return;
        isFireTimeSet = true;
        fireTime = (int) (Math.random() * 5 + 3) * 60;

    }

}
