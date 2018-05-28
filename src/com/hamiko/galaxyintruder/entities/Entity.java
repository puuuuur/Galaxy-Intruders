package com.hamiko.galaxyintruder.entities;

import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;

public abstract class Entity {

    //TODO sound effect manager
    //TODO hitbox
    //TODO AI
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

    public void setCoords(int x,int  y){
        this.x = x;
        this.y = y;

    }

    public abstract GraphicsManager getGraphics();

    public abstract void update();

}
