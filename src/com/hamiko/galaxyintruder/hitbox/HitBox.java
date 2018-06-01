package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;

public class HitBox {

    private Position position;

    private int width;
    private int height;

    private int offsetX;
    private int offsetY;

    //NOTE: using this constructor means that this hitbox will not follow a entity
    public HitBox(int x, int y, int width, int height) {
        this(new Position(x, y), width, height);
    }

    public HitBox(Position position, int width, int height) {

        this.position = position;
        this.width = width;
        this.height = height;

    }

    public Position getPosition() {
        return position;
    }

    public int getX(){
        return position.x + offsetX;
    }

    public int getY(){
        return position.y + offsetY;
    }

    public int getWidth() {
        return width;
    }

    public HitBox setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public HitBox setHeight(int height) {
        this.height = height;
        return this;
    }

    void setOffsetX(int offsetX) {
        this.offsetX = GameScale.xScale(offsetX);
    }

    void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

}
