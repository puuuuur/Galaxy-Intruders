package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.graphics.ScaledGraphics;
import com.hamiko.galaxyintruder.level.GameLevel;

import java.awt.*;

public class GamePlayView extends GameView {

    private GameLevel level;

    public void render(Graphics g){

        ScaledGraphics gx = new ScaledGraphics(g);

        gx.getGraphics().setColor(Color.white);
        gx.getGraphics().drawString("Player coords(x: " + Player.global.getX() + " y: " + Player.global.getY() + ")", 5, 12);

        gx.drawEntity(level.getPlayer());

        for (Entity e : level.getEnemyPool()) {
            gx.drawEntity(e);
        }

        for (Entity e : level.getProjectilesPool()) {
            gx.drawEntity(e);
        }

    }
    public void setLevel(GameLevel level) {
        this.level = level;
    }

}
