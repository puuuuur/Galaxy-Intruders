package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;

public class EnemyBulletAnimation extends AnimationStudio {

    Sprite bullet;

    public EnemyBulletAnimation(GraphicsManager graphicsManager) {
        super(graphicsManager);

        this.bullet = new Sprite(graphicsManager.getSpriteSheet().getSprite(0, 0).getImage());

    }


    public Sprite bulletDown(){
        return this.bullet;
    }

}
