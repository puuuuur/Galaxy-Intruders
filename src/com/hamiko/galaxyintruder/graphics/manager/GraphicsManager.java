package com.hamiko.galaxyintruder.graphics.manager;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public abstract class GraphicsManager {

    private Sprite defaultSprite;
    private Sprite currentSprite;

    public abstract SpriteSheet getSpriteSheet();

    public abstract AnimationStudio getAnimations();

    public Sprite getDefaultSprite() {
        return defaultSprite;
    }

    public Sprite getCurrentSprite() {
        return currentSprite;
    }


    protected void setDefaultSprite(Sprite defaultSprite) {
        this.defaultSprite = defaultSprite;
    }


    public void setCurrentSprite(Sprite currentSprite) {
        this.currentSprite = currentSprite;
    }

}
