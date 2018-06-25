package com.hamiko.galaxyintruder.graphics.manager.enemies;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class BasicSmallShipGraphics extends GraphicsManager {

    private SpriteSheet spriteSheet;
    private AnimationStudio animation;

    public BasicSmallShipGraphics() {

        spriteSheet = SpriteSheetContainer.getSpriteSheet("res/entities/enemies/SmallPlane.png", 16, 1, 1);
        animation  = new AnimationStudio(this);
        setCurrentSprite(spriteSheet.getSprite(0, 0));
        setDefaultSprite(spriteSheet.getSprite(0, 0));

    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    @Override
    public AnimationStudio getAnimations() {
        return animation;
    }

}
