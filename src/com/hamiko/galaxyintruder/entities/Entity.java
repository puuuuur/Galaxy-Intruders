package com.hamiko.galaxyintruder.entities;

import com.hamiko.galaxyintruder.graphics.handler.GraphicsManager;

public abstract class Entity {

    //TODO sound effect manager
    //TODO hitbox
    //TODO AI
    protected GraphicsManager spriteManager;

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GraphicsManager getGraphics() {
        return spriteManager;
    }

    public abstract void update();

}
