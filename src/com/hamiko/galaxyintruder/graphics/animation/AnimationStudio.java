package com.hamiko.galaxyintruder.graphics.animation;

import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;

public class AnimationStudio {

    private boolean done = false;

    private int lastSpriteX;
    private int lastSpriteY;

    private int frameX;
    private int frameY;

    private GraphicsManager graphicsManager;

    public AnimationStudio(GraphicsManager graphicsManager) {
        this.graphicsManager = graphicsManager;
    }

    public GraphicsManager getGraphicsManager() {
        return graphicsManager;
    }

    public AnimationStudio setGraphicsManager(GraphicsManager graphicsManager) {
        this.graphicsManager = graphicsManager;
        return this;
    }

    public Sprite getDefault() {
        return this.graphicsManager.getSpriteSheet().getSprite(0, 0);
    }

    public void update(){

    }

    public boolean isDone(){
        return done;
    }

    public void setIsDone(){
        done = true;
    }

    public int getLastSpriteX() {
        return lastSpriteX;
    }

    public int getLastSpriteY() {
        return lastSpriteY;
    }

    public int getFrameX() {
        return frameX;
    }

    public void setFrameX(int frameX) {
        this.frameX = frameX;
    }

    public int getFrameY() {
        return frameY;
    }

    public void setFrameY(int frameY) {
        this.frameY = frameY;
    }

    /**
     * Set last sprite sheet indexes in col and row
     * @param row Row index
     * @param col Col index
     */
    public void setBoundaries(int row, int col) {
        this.lastSpriteX = row;
        this.lastSpriteY = col;
    }

    public int nextFrameX(){
        return this.frameX++;
    }

    public int nextFrameY(){
        return this.frameY++;
    }

}
