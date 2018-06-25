package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.projectiles.BasicBullet;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.scenes.GameLevel;

public class MainGun {

    private SpaceShipInput input;
    private GameLevel level;

    private int offsetX;
    private int offsetY;

    private int firingSpeed = 45;//60 is one second NOTE: If fps shall be fluctuating, this WILL need a time scaling
    private int fireRoutine = 0;
    private int firePreload = firingSpeed;

    public MainGun(SpaceShipInput input, GameLevel level) {
        this.input = input;
        this.level = level;
    }

    void update(Player player) {

        if (input.fire()) {

            if (firingSpeed == fireRoutine || firePreload == firingSpeed) {

                new BasicBullet(
                        player.getX() + offsetX,
                        player.getY() + offsetY,
                        level
                );


                fireRoutine = 0;
                firePreload = 0;

            } else {
                fireRoutine++;
                firePreload++;
            }

        } else {

            if (!(firePreload == firingSpeed)) {
                firePreload++;
            }

            fireRoutine = 0;

        }

    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
}
