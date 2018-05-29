package com.hamiko.galaxyintruder.hitbox;

import java.awt.*;

public class HitBox {

    private Point position;

    private int width;
    private int height;

    private int offsetX;
    private int offsetY;

    public HitBox(int x, int y, int width, int height) {
        this(new Point(x, y), width, height);
    }

    public HitBox(Point position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Point getPosition() {
        return position;
    }

    public HitBox setPosition(Point position) {
        this.position = position;
        return this;
    }

    public HitBox setPosition(int x, int y) {
        this.position.setLocation(x, y);
        return this;
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

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

}
