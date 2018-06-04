package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.graphics.manager.BasicBulletGraphics;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;

public class BasicBullet extends Projectile {

    private BasicBulletGraphics spriteManager = new BasicBulletGraphics();
    private SimpleHitBoxManager hitBoxManager;
    private int speed = GameScale.yScale(3);
    private int power = 10;


    public BasicBullet(int x, int y, GameLevel level) {
        super(level);
        setLocation(x, y);
        this.level = level;
        this.hitBoxManager = new SimpleHitBoxManager(this);
        level.getProjectilesPool().add(this);
    }

    @Override
    public void update() {


        boolean isKilled = false;

        for (Enemy enemy : level.getEnemyPool()) {

            for (HitBox box : enemy.getHitBoxManager().getHitBoxes()) {

                //TODO make some logic that makes  sense. maybe determine borders or some kind of surface
                //Definitely need a system that can determine the type of hit box, and the potential hit area
                //Its probably a good idea to calculate this thinks before head
                //IDEA 1: getState a detection interface that every hit box implements
                //        a) In this interface we determine the border surface
                if (box.getY() + box.getHeight() / 2 >= getY() - getHeight() / 2) {

                    if (
                            box.getX() + box.getWidth() / 2 >= hitSurfaceXLeft()
                                    && box.getX() - box.getWidth() / 2 <= hitSurfaceXRight()
                            ) {
                        isKilled = true;
                        enemy.takeDamage(power);
                    }

                }

            }

        }

        if (getY() <= 0) {

            isKilled = true;

        }

        if (isKilled) {
            level.getProjectilesPool().kill(this);
            return;
        }

        setY(getY() - speed);

    }

    public int hitSurfaceXLeft() {
        return getX() - getWidth() / 2;
    }

    public int hitSurfaceXRight() {
        return getX() + getWidth() / 2;
    }

    @Override
    public GraphicsManager getGraphics() {
        return spriteManager;
    }

    @Override
    public HitBoxManager getHitBoxManager() {
        return hitBoxManager;
    }

    @Override
    public Owner owner() {
        return Owner.PLAYER;
    }

}
