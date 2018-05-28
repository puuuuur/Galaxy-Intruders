package com.hamiko.galaxyintruder.graphics.sprite;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;

public class PlayerSpriteSheet extends SpriteSheet {

    private Sprite left;

    public PlayerSpriteSheet() {
        super("res/entities/player/PlaneOne.png", 32, 2, 1);
        left = new Sprite(ImageRefactor.flipHorizontally(this.getSprite(0, 1).getImage()));
    }

    public Sprite getShipDefault() {
        return this.getSprite(0, 0);
    }

    public Sprite getShipLeft() {
        return left;
    }

    public Sprite getShipRight() {
        return this.getSprite(0, 1);
    }

}
