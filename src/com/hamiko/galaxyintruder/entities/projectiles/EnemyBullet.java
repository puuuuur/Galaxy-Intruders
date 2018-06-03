package com.hamiko.galaxyintruder.entities.projectiles;

import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.graphics.manager.BasicBulletGraphics;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.graphics.window.Screen;

public class EnemyBullet extends Projectile {

    private BasicBulletGraphics spriteManager = new BasicBulletGraphics();
    private SimpleHitBoxManager hitBoxManager;
    private int speed = GameScale.yScale(3);
    private int power = 10;


    public EnemyBullet(int x, int y, GameLevel level) {
        super(level);
        setLocation(x, y);
        this.level = level;
        this.hitBoxManager = new SimpleHitBoxManager(this);
        level.getProjectilesPool().add(this);

    }

    @Override
    public void update() {


        boolean isKilled = false;

        Player player = level.getPlayer();


        for (HitBox box : player.getHitBoxManager().getHitBoxes()) {

            if (box.getY() - box.getHeight() / 2 <= getY() + getHeight() / 2) {

                if (
                        box.getX() + box.getWidth() / 2 >= hitSurfaceXLeft()
                                && box.getX() - box.getWidth() / 2 <= hitSurfaceXRight()
                        ) {
                    isKilled = true;
                    player.takeDamage(power);
                }

            }

        }


        if (getY() >= Screen.getInstance().getHeight()) {
            isKilled = true;
        }

        if (isKilled) {
            level.getProjectilesPool().kill(this);
            return;
        }

        setY(getY() + speed);

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
        return Owner.ENEMY;
    }

}
