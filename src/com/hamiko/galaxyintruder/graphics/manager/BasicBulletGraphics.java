package com.hamiko.galaxyintruder.graphics.manager;

import com.hamiko.galaxyintruder.entities.projectiles.EnemyBulletAnimation;
import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class BasicBulletGraphics extends GraphicsManager {

    private SpriteSheet spritesSheet;
    private EnemyBulletAnimation animation;

    public BasicBulletGraphics() {

        spritesSheet = SpriteSheetContainer.getSpriteSheet("res/entities/projectiles/BasicBullet.png", 8, 1, 1);
        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

        animation = new EnemyBulletAnimation(spritesSheet);

        this.setCurrentSprite(animation.bulletDown());

    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spritesSheet;
    }

    @Override
    public AnimationStudio getAnimations() {
        return animation;
    }

    public void rotateSprite(int y, int x){
        Sprite image = spritesSheet.getSprite(y, x);
        image.setImage(ImageRefactor.rotateImage(image.getImage()));
    }

}
