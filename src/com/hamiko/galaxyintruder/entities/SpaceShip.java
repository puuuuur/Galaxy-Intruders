package com.hamiko.galaxyintruder.entities;

import com.hamiko.galaxyintruder.scenes.GameLevel;

public abstract class SpaceShip extends Entity {

    //TODO needs a invulnerability period
    private int maxHealth;
    private int health;
    private boolean isDamaged;

    public SpaceShip(GameLevel level, int health) {
        super(level);
        this.health = health;
        this.maxHealth = health;
    }


    public void takeDamage(int dmg) {
        isDamaged = true;
        setHealth(getHealth() - dmg);
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public boolean isDamaged() {
        return this.isDamaged;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

}
