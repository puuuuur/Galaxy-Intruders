package com.hamiko.galaxyintruder.graphics.manager.enemies;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.enemies.SmallShipSpriteSheet;

public class BasicSmallShipGraphics extends GraphicsManager {

    SmallShipSpriteSheet spriteSheet = new SmallShipSpriteSheet();

    public BasicSmallShipGraphics() {
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
