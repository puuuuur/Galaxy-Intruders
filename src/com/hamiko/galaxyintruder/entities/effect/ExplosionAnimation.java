package com.hamiko.galaxyintruder.entities.effect;

import com.hamiko.galaxyintruder.graphics.animation.AnimationStudio;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;

public class ExplosionAnimation extends AnimationStudio {

    public ExplosionAnimation(GraphicsManager graphicsManager) {
        super(graphicsManager);
        setBoundaries(5, 5);
    }

    @Override
    public void update() {

        if (isDone())return;

        if (getFrameX() != getLastSpriteX()) {
            getGraphicsManager().
                    setCurrentSprite(getGraphicsManager().getSpriteSheet().getSprite(getFrameY(), nextFrameX()));
        } else {

            setFrameX(0);

            if (getFrameY() != getLastSpriteY()) {
                getGraphicsManager().
                        setCurrentSprite(getGraphicsManager().getSpriteSheet().getSprite(nextFrameY(), getFrameX()));
            }

        }

        if (getFrameX() == getLastSpriteX() && getFrameY() == getLastSpriteY()) {
            getGraphicsManager().setCurrentSprite(null);
            setIsDone();
        }

    }

}
