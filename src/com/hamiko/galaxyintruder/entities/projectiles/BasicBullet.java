package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.manager.BasicBulletGraphics;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;

public class BasicBullet extends Entity {

    private BasicBulletGraphics spriteManager = new BasicBulletGraphics();
    private SimpleHitBoxManager hitBoxManager;
    private int speed = GameScale.yScale(3);
    private int power = 10;

    private GameLevel level;

    public BasicBullet(int x, int y, GameLevel level) {
        setLocation(x, y);
        this.level = level;
        this.hitBoxManager = new SimpleHitBoxManager(this);
    }

    @Override
    public GraphicsManager getGraphics() {
        return spriteManager;
    }

    @Override
    public void update() {

        if (getY() <= 0) {

            level.getProjectilesPool().kill(this);
            return;
        }

        setY(getY() - speed);

    }

    @Override
    public HitBoxManager getHitBoxManager() {
        return hitBoxManager;
    }

}
