package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.graphics.ScaledGraphics;
import com.hamiko.galaxyintruder.level.GameLevel;

import java.awt.*;

public class GamePlayView extends GameView {

    private GameLevel level;
    private ScaledGraphics gx = new ScaledGraphics();

    public void render(Graphics g) {

        gx.setGraphics(g);

        gx.getGraphics().setColor(Color.white);
        gx.getGraphics().drawString("Player coords(x: " + Player.global.getX() + " y: " + Player.global.getY() + ")", 5, 12);

        gx.drawSpaceShip(level.getPlayer());

        for (SpaceShip e : level.getEnemyPool()) {
            gx.drawSpaceShip(e);
        }

        for (Projectile p : level.getProjectilesPool()) {
            gx.drawProjectile(p);
        }

    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

}
