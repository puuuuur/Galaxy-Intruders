package com.hamiko.galaxyintruder.entities.enemies.small;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class BasicBulletAnimation extends AnimationStudio {

    Sprite down;
    Sprite up;

    public BasicBulletAnimation(SpriteSheet spriteSheet) {

        super(spriteSheet);
        this.up = spriteSheet.getSprite(0,0);
        this.down = spriteSheet.getSprite(0,0).copy();
        this.down.setImage(ImageRefactor.rotateImage(down.getImage()));//TODO cache or rotate this shit in bullet sprite sheet

    }

    public Sprite down(){
        return down;
    }

    public Sprite up(){
        return up;
    }

}
