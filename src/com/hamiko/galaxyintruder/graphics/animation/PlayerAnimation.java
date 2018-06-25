package com.hamiko.galaxyintruder.graphics.animation;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class PlayerAnimation extends AnimationStudio{

    Sprite center;
    Sprite left;
    Sprite right;
    GraphicsManager graphics;

    public PlayerAnimation(GraphicsManager graphics) {
        super(graphics);

        SpriteSheet spriteSheet = graphics.getSpriteSheet();
        this.graphics = graphics;
        this.center = spriteSheet.getSprite(0,0);
        this.right = spriteSheet.getSprite(0,1);
        this.left = new Sprite(ImageRefactor.flipHorizontally(spriteSheet.getSprite(0, 1).getImage()));

    }

    public void animateCenter() {
        graphics.setCurrentSprite(center);
    }

    public void animateLeft() {
        graphics.setCurrentSprite(left);
    }

    public void animateRight() {
        graphics.setCurrentSprite(right);
    }
}
