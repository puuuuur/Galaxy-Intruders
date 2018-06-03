package com.hamiko.galaxyintruder.entities.enemies;

import com.hamiko.galaxyintruder.entities.projectiles.EnemyBullet;
import com.hamiko.galaxyintruder.level.GameLevel;

public class Gun {

    GameLevel level;

    public Gun(GameLevel level) {
        this.level = level;
    }

    public void shootWeapon(Enemy enemy){

        new EnemyBullet(
                enemy.getX(),
                enemy.getY() + enemy.getHeight() / 3,
                level
        );

    }

}
