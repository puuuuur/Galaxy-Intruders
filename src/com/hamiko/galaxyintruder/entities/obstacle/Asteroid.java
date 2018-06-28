package com.hamiko.galaxyintruder.entities.obstacle;

import com.hamiko.galaxyintruder.entities.effect.Explosion;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;

public class Asteroid extends Projectile {

    private GraphicsManager graphics;
    private HitBoxManager hitbox;

    public Asteroid(GameLevel level) {
        super(level);
        graphics = new AsteroidGraphics();
        hitbox = new SimpleHitBoxManager(this);
    }

    @Override
    public GraphicsManager getGraphics() {
        return graphics;
    }

    @Override
    public HitBoxManager getHitBoxManager() {
        return hitbox;
    }

    @Override
    public void update() {

        for (Projectile p : level.getProjectilesPool()) {

            if(p == this)continue;

            for (HitBox box : p.getHitBoxManager().getHitBoxes()) {

                boolean hit = this.hitbox.getHitBoxes().get(0).intersects(box);

                if (hit) {
                    System.out.println("you were hit");
                    this.level.getEffectsPool().add(
                            new Explosion(
                                    this.level,
                                    new Position(this.getPosition()), "res/entities/effects/explosion_small.png")
                    );

                }

            }

        }

    }

}
