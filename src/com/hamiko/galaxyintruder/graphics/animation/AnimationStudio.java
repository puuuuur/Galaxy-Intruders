package com.hamiko.galaxyintruder.graphics.animation;

import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class AnimationStudio {

    private SpriteSheet spriteSheet;

    public AnimationStudio(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

}
