package com.hamiko.galaxyintruder.entities;

import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;

import java.awt.*;

public abstract class Entity {

    //TODO sound effect manager
    //TODO AI

    private Point position = new Point();

    public int getX() {
        return position.x;
    }

    public void setX(int x) {
        this.position.x = x;
    }

    public int getY() {
        return position.y;
    }

    public void setY(int y) {
        this.position.y = y;
    }

    public void setLocation(int x, int  y){
        position.setLocation(x, y);
    }

    public int getWidth() {
        return getGraphics().getCurrentSprite().getImage().getWidth();
    }

    public int getHeight() {
        return getGraphics().getCurrentSprite().getImage().getHeight();
    }


    public Point getPosition() {
        return this.position;
    }

    public abstract GraphicsManager getGraphics();
    public abstract HitBoxManager getHitBoxManager();
    public abstract void update();

}
