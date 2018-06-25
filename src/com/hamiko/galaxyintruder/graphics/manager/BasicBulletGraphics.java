package com.hamiko.galaxyintruder.graphics.manager;

import com.hamiko.galaxyintruder.entities.projectiles.BasicBulletAnimation;
import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class BasicBulletGraphics extends GraphicsManager {

    private SpriteSheet spritesSheet;
    private BasicBulletAnimation animation;

    public BasicBulletGraphics(String uri) {

        spritesSheet = SpriteSheetContainer.getSpriteSheet(uri, 8, 1, 1);
        animation = new BasicBulletAnimation(this);

        this.setCurrentSprite(this.getSpriteSheet().getSprite(0, 0));
        this.setDefaultSprite(this.getSpriteSheet().getSprite(0, 0));

    }

    @Override
    public SpriteSheet getSpriteSheet() {
        return spritesSheet;
    }

    @Override
    public BasicBulletAnimation getAnimations() {
        return animation;
    }

    public void rotateSprite(int y, int x){
        Sprite image = spritesSheet.getSprite(y, x);
        image.setImage(ImageRefactor.rotateImage(image.getImage()));
    }

}
