package com.hamiko.galaxyintruder.graphics.handler;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class GraphicsManager {

    private SpriteSheet spriteSheet;
    private AnimationStudio animations;
    private Sprite defaultSprite;
    private Sprite currentSprite;


    public GraphicsManager(SpriteSheet spriteSheet, AnimationStudio animations) {
        this.spriteSheet = spriteSheet;
        this.animations = animations;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public Sprite getDefaultSprite() {
        return defaultSprite;
    }

    public Sprite getCurrentSprite() {
        return currentSprite;
    }

    public AnimationStudio getAnimations() {
        return animations;
    }

    void setDefaultSprite(Sprite defaultSprite) {
        this.defaultSprite = defaultSprite;
    }


    void setCurrentSprite(Sprite currentSprite) {
        this.currentSprite = currentSprite;
    }
}
