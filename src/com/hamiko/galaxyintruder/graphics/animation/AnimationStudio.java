package com.hamiko.galaxyintruder.graphics.animation;

import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;

public class AnimationStudio {

    private GraphicsManager graphicsManager;

    public AnimationStudio(GraphicsManager spriteSheet) {
        this.graphicsManager = spriteSheet;
    }

    public GraphicsManager getGraphicsManager() {
        return graphicsManager;
    }

    public AnimationStudio setGraphicsManager(GraphicsManager graphicsManager) {
        this.graphicsManager = graphicsManager;
        return this;
    }

    public Sprite getDefault() {
        return this.graphicsManager.getSpriteSheet().getSprite(0, 0);
    }

}
