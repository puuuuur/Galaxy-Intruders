package com.hamiko.galaxyintruder.graphics.manager;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.projectiles.BulletSpritesSheet;

public class BasicBulletGraphics extends GraphicsManager {

    private BulletSpritesSheet spritesSheet;

    public BasicBulletGraphics() {

        spritesSheet = new BulletSpritesSheet();
        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spritesSheet;
    }

    @Override
    public AnimationStudio getAnimations() {
        return null;
    }
}
