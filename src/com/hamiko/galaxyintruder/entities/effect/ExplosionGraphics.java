package com.hamiko.galaxyintruder.entities.effect;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheet;
import com.hamiko.galaxyintruder.graphics.sprite.SpriteSheetContainer;

public class ExplosionGraphics extends GraphicsManager {

    private SpriteSheet spriteSheet;
    private AnimationStudio animation;

    public ExplosionGraphics(String uri) {

        //TODO remove this hardcoded nonsense after rescaled image cache is done
        int width = (uri == "res/entities/effects/explosion_small.png") ? 20 : 50;

        this.spriteSheet = SpriteSheetContainer.getSpriteSheet(uri, width, 6, 6, 0.5d);
        this.animation = new ExplosionAnimation(this);
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
