package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;

public class BasicBulletAnimation extends AnimationStudio {

    private Sprite down;
    private Sprite up;

    public BasicBulletAnimation(GraphicsManager graphicsManager) {

        super(graphicsManager);
        this.up = graphicsManager.getSpriteSheet().getSprite(0,0);
        this.down = graphicsManager.getSpriteSheet().getSprite(0,0).copy();
        this.down.setImage(ImageRefactor.rotateImage(down.getImage()));//TODO cache or rotate this shit in bullet sprite sheet

    }

    public Sprite down(){
        return down;
    }

    public Sprite up(){
        return up;
    }

}
