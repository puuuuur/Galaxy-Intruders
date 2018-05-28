package com.hamiko.galaxyintruder.entities.enemies;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.manager.enemies.BasicSmallShipGraphics;
import com.hamiko.galaxyintruder.hitbox.Enemies.BasicSmallShipHitBoxManager;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;

public class BasicSmallShip extends Entity{

    private GraphicsManager graphicsManager = new BasicSmallShipGraphics();
    private SimpleHitBoxManager hitBoxManager;
    public BasicSmallShip() {
        setX(500);
        setY(50);

        hitBoxManager = new SimpleHitBoxManager(this);
    }

    @Override
    public GraphicsManager getGraphics() {
        return graphicsManager;
    }

    @Override
    public void update() {

    }

    @Override
    public HitBoxManager getHitBoxManager() {
        return hitBoxManager;
    }
}
