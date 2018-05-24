package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.ScaledGraphics;
import com.hamiko.galaxyintruder.level.GameLevel;

import java.awt.*;

public class GamePlayView extends GameView {

    private GameLevel level;

    @Override
    public void paintComponent(Graphics gx) {

        ScaledGraphics g = new ScaledGraphics(gx);

        g.drawEntity(level.getPlayer());

        for (Entity e : level.getEnemyPool()) {
            g.drawEntity(e);
        }

    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

}
