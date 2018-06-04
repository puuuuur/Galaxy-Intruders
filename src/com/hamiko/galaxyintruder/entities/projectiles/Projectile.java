package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.scenes.GameLevel;

public abstract class Projectile extends Entity {

    public Projectile(GameLevel level) {
        super(level);
    }

    public enum Owner {
        PLAYER,
        ENEMY
    }

    public abstract Owner owner();

}
