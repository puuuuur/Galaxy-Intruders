package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.projectiles.BasicBullet;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;

public class MainGun {

    SpaceShipInput input;
    GameLevel level;

    private int firingSpeed = 45;//60 is one second
    private int fireRoutine = 0;
    private int firePreload = firingSpeed;

    public MainGun(SpaceShipInput input, GameLevel level) {
        this.input = input;
        this.level = level;
    }

    public void fireMainWeapon(Player player) {

        if (input.fire()) {

            if (firingSpeed == fireRoutine || firePreload == firingSpeed) {

                BasicBullet bullet = new BasicBullet(
                        player.getX(),
                        player.getY() - player.getGraphics().getCurrentSprite().getImage().getWidth() / 2,
                        level
                );

                player.level.getProjectilesPool().add(bullet);

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


}
