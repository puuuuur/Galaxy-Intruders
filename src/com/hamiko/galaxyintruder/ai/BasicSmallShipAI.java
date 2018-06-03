package com.hamiko.galaxyintruder.ai;

import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.enemies.BasicSmallShip;

public class BasicSmallShipAI implements Behavior {

    private int fireCounter = 0;
    private int fireTime;
    private boolean isFireTimeSet;

    @Override
    public void act(SpaceShip s) {

        if (fireCounter++ >= fireTime) {

            BasicSmallShip ship = (BasicSmallShip) s;
            ship.getGun().shootWeapon(ship);

            fireCounter = 0;

        }

        setFireTime();

    }

    private void setFireTime() {

        if (isFireTimeSet) return;
        isFireTimeSet = true;

        fireTime = (int) (Math.random() * 3) + 4;

    }

}
