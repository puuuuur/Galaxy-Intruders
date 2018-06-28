package com.hamiko.galaxyintruder.entities.obstacle;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class AsteroidGraphics extends GraphicsManager {

    private SpriteSheet spriteSheet = new SpriteSheet("res/entities/projectiles/asteroid_one.png", 23, 1, 1);

    public AsteroidGraphics() {
        setCurrentSprite(spriteSheet.getSprite(0, 0));
        setDefaultSprite(spriteSheet.getSprite(0, 0));
    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    @Override
    public AnimationStudio getAnimations() {
        return null;
    }

}
