package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.graphics.animation.PlayerAnimation;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class PlayerGraphics extends GraphicsManager {

    private SpriteSheet spriteSheet;
    private PlayerAnimation animation;

    PlayerGraphics() {

        spriteSheet = SpriteSheetContainer.getSpriteSheet("res/entities/player/PlaneOne.png", 32, 2, 1);
        animation = new PlayerAnimation(this);

        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    @Override
    public PlayerAnimation getAnimations() {
        return animation;
    }

}
