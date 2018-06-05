package com.hamiko.galaxyintruder.graphics.manager.enemies;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class BasicSmallShipGraphics extends GraphicsManager {

    private SpriteSheet spriteSheet;

    public BasicSmallShipGraphics() {

        spriteSheet = SpriteSheetContainer.getSpriteSheet("res/entities/enemies/SmallPlane.png", 16, 1, 1);
        setCurrentSprite(spriteSheet.getSprite(0, 0));

        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

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
