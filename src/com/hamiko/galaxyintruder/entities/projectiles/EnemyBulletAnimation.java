package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;

public class EnemyBulletAnimation extends AnimationStudio {


    Sprite bullet;

    public EnemyBulletAnimation(SpriteSheet spriteSheet) {
        super(spriteSheet);

        this.bullet = new Sprite(spriteSheet.getSprite(0, 0).getImage());
//        this.bullet = new Sprite(ImageRefactor.flipHorizontally(spriteSheet.getSprite(0, 0).getImage()));

    }


    public Sprite bulletDown(){
        return this.bullet;
    }

}
