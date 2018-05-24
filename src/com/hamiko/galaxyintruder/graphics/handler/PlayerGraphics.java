package com.hamiko.galaxyintruder.graphics.handler;

import com.hamiko.galaxyintruder.graphics.animation.PlayerAnimation;
import com.hamiko.galaxyintruder.graphics.sprite.PlayerSpriteSheet;

public class PlayerGraphics extends GraphicsManager {


    public PlayerGraphics() {

        super(new PlayerSpriteSheet(), new PlayerAnimation());
        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

    }

}
