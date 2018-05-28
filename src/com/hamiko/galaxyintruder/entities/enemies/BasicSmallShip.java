package com.hamiko.galaxyintruder.entities.enemies;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.manager.enemies.BasicSmallShipGraphics;

public class BasicSmallShip extends Entity{

    GraphicsManager graphicsManager = new BasicSmallShipGraphics();

    public BasicSmallShip() {
        setX(500);
        setY(50);
    }

    @Override
    public GraphicsManager getGraphics() {
        return graphicsManager;
    }

    @Override
    public void update() {

    }
}
