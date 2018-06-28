package com.hamiko.galaxyintruder.entities.effect;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.scenes.GameLevel;

public abstract class Effect extends Entity {

    public Effect(GameLevel level) {
        super(level);
    }

    @Override
    public HitBoxManager getHitBoxManager() {
        return null;
    }

}
