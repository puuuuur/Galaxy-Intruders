package com.hamiko.galaxyintruder.graphics.manager;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.animation.PlayerAnimation;
import com.hamiko.galaxyintruder.graphics.sprite.PlayerSpriteSheet;

public class PlayerGraphics extends GraphicsManager {

    private PlayerSpriteSheet spriteSheet;
    private PlayerAnimation animation;

    public PlayerGraphics() {

        spriteSheet = new PlayerSpriteSheet();
        animation = new PlayerAnimation();
        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

    }

    @Override
    public PlayerSpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    @Override
    public AnimationStudio getAnimations() {
        return animation;
    }

}
