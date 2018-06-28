package com.hamiko.galaxyintruder.graphics.background;

import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;

public class BackGroundHandler implements Drawable {

    private Background first;
    private Background second;

    private int heightOffset;

    public BackGroundHandler() {

        this.first = new Background(new Position(0, 0));
        int offsetY = (int) (first.getImage().getHeight() / GameScale.yScale());
        this.second = new Background(new Position(0, -offsetY));
        heightOffset = first.getImage().getHeight();

    }

    public void update() {

        this.first.getPosition().y += 1;
        this.second.getPosition().y += 1;

        if (this.first.getPosition().y > heightOffset / 2) {
            this.first.getPosition().y = -heightOffset * 2 + heightOffset / 2;
        }

        if (this.second.getPosition().y > heightOffset / 2) {
            this.second.getPosition().y  = -heightOffset * 2 + heightOffset / 2;
        }

    }

    @Override
    public void render(GameGraphics graphics) {
        this.first.render(graphics);
        this.second.render(graphics);
    }

}
