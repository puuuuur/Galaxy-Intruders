package com.hamiko.galaxyintruder.entities.enemies;

import com.hamiko.galaxyintruder.ai.Behavior;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.scenes.GameLevel;

public abstract class Enemy extends SpaceShip{

    public Enemy(GameLevel level, int health) {
        super(level, health);
    }

    @Override
    public void takeDamage(int dmg) {

        super.takeDamage(dmg);

        if (getHealth() <= 0) {
            this.level.getEnemyPool().kill(this);
            this.level.getScorePanel().updateScore(getPoints());
        }

    }

    public abstract Behavior getBehavior();
    public abstract int getPoints();


}
