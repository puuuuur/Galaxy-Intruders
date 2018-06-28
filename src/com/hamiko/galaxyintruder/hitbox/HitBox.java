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

    public void setOffsetX(int offsetX) {
        this.offsetX = GameScale.xScale(offsetX);
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    //TODO this method needs more testing before deployment
    public boolean intersects(HitBox other){

        int myX = this.getX() - this.getX() / 2;
        int myY = this.getY() - this.getY() / 2;

        int myWidth = myX + this.getWidth();
        int myHeight = myY + this.getHeight();

        int otherX = other.getX() - other.getX() / 2;
        int otherY = other.getY() - other.getY() / 2;

        int otherWidth = otherX + other.getWidth();
        int otherHeight = otherY + other.getHeight();

        if(myX <= otherX && myWidth >= otherX){

            if(myY <= otherY && myHeight >= otherY){
                return true;
            }

        }else if(myX <= otherWidth && myWidth >= otherWidth){

            if(myY <= other.getY() && myHeight >= otherY){
                return true;
            }

        }else if(myX <= otherX && myWidth >= otherX){

            if(myY <= otherHeight && myHeight >= otherHeight){
                return true;
            }

        }else if(myX <= otherWidth && myWidth >= otherWidth){

            if(myY <= otherHeight && myHeight >= otherHeight){
                return true;
            }

        }

        return false;

    }

}
