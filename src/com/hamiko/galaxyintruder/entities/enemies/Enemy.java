package com.hamiko.galaxyintruder.entities.enemies;

import com.hamiko.galaxyintruder.ai.BehaviorManager;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.effect.Explosion;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.sound.SoundManager;

public abstract class Enemy extends SpaceShip{

    public Enemy(GameLevel level, int health) {
        super(level, health);
    }

    @Override
    public void takeDamage(int dmg) {

        SoundManager p = new SoundManager();
        String uri = "res/sounds/explosion/damage_one.wav";
        p.loadSoundEffects("exp", uri);
        p.playSound("exp");

        super.takeDamage(dmg);

        if (getHealth() <= 0) {

            this.level.getEffectsPool().add(new Explosion(this.level, new Position(this.getPosition())));
            this.level.getEnemyPool().kill(this);
            this.level.updateScore(getPoints());

        }

    }

    public abstract BehaviorManager getBehavior();
    public abstract int getPoints();

    @Override
    public void update() {
        getBehavior().act(this);
    }

}
