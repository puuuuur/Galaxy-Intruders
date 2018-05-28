package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.handler.BasicBulletGraphics;
import com.hamiko.galaxyintruder.graphics.handler.GraphicsManager;

public class BasicBullet extends Entity {

    private BasicBulletGraphics spriteManager = new BasicBulletGraphics();

    public BasicBullet(int x, int y) {
        setCoords(x, y);
    }

    @Override
    public GraphicsManager getGraphics() {
        return spriteManager;
    }


    @Override
    public void update() {

        setY(getY() - 9);

    }

}
