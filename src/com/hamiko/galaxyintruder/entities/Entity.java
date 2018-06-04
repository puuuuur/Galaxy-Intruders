package com.hamiko.galaxyintruder.entities;

import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.Position;

public abstract class Entity {

    //TODO sound effect manager
    //TODO AI

    private Position position = new Position();
    protected GameLevel level;

    public Entity(GameLevel level){
        this.level = level;
    }

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
        return (int)getGraphics().getCurrentSprite().getDimension().getWidth();
    }

    public int getHeight() {
        return (int)getGraphics().getCurrentSprite().getDimension().getHeight();
    }

    public Position getPosition() {
        return this.position;
    }

    public abstract GraphicsManager getGraphics();
    public abstract HitBoxManager getHitBoxManager();

    public abstract void update();

}
