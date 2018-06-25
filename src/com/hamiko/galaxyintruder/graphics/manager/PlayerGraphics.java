package com.hamiko.galaxyintruder.graphics.manager;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.animation.PlayerAnimation;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class PlayerGraphics extends GraphicsManager {

    private SpriteSheet spriteSheet;
    private PlayerAnimation animation;

    public PlayerGraphics() {

        spriteSheet = SpriteSheetContainer.getSpriteSheet("res/entities/player/PlaneOne.png", 32, 2, 1);
        animation = new PlayerAnimation(spriteSheet);
        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

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
