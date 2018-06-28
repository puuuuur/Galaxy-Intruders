package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.entities.effect.Explosion;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.graphics.manager.BasicBulletGraphics;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.sound.SoundManager;

public class BasicBullet extends Projectile {

    private BasicBulletGraphics spriteManager = new BasicBulletGraphics("res/entities/projectiles/PlayerBullet.png");
    private SimpleHitBoxManager hitBoxManager;
    private int speed = GameScale.yScale(3);
    private int power = 10;

    public BasicBullet(int x, int y, GameLevel level) {

        super(level);
        setLocation(x, y);
        this.level = level;
        this.hitBoxManager = new SimpleHitBoxManager(this);
        level.getProjectilesPool().add(this);
        SoundManager p = new SoundManager();
        p.loadSoundEffects("laser", "res/sounds/blaster-firing.wav");
        p.playSound("laser");

    }

    @Override
    public void update() {

        boolean isKilled = false;

        for (Enemy enemy : level.getEnemyPool()) {

            for (HitBox box : enemy.getHitBoxManager().getHitBoxes()) {

                if (box.getY() + box.getHeight() / 2 >= getY() - getHeight() / 2) {

                    if (
                            box.getX() + box.getWidth() / 2 >= hitSurfaceXLeft()
                                    && box.getX() - box.getWidth() / 2 <= hitSurfaceXRight()
                            ) {
                        isKilled = true;
                        this.level.getEffectsPool().add(new Explosion(
                                this.level,
                                new Position(this.getPosition()), "res/entities/effects/explosion_small.png")
                        );
                        enemy.takeDamage(power);
                    }

                }

            }

        }

        if (getY() <= 0)isKilled = true;

        if (isKilled) {
            level.getProjectilesPool().kill(this);
            return;
        }

        setY((int) (getY() - speed * GameScale.interpolation()));

    }

    private int hitSurfaceXLeft() {
        return getX() - getWidth() / 2;
    }

    private int hitSurfaceXRight() {
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

}
