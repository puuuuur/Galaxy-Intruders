package com.hamiko.galaxyintruder.graphics.animation;

import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class AnimationStudio {

    SpriteSheet spriteSheet;

    public AnimationStudio(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public AnimationStudio setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
        return this;
    }

}
