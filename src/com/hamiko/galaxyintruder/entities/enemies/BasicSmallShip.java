package com.hamiko.galaxyintruder.entities.enemies;

import com.hamiko.galaxyintruder.ai.BasicSmallShipAI;
import com.hamiko.galaxyintruder.ai.Behavior;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.manager.enemies.BasicSmallShipGraphics;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.graphics.window.Screen;

public class BasicSmallShip extends Enemy {

    private GraphicsManager graphicsManager = new BasicSmallShipGraphics();
    private BasicSmallShipAI behavior = new BasicSmallShipAI();
    private SimpleHitBoxManager hitBoxManager = new SimpleHitBoxManager(this);
    private Gun gun;

    private static final int BASE_HEALTH = 100;

    public BasicSmallShip(GameLevel level, Position position) {
        super(level, BASE_HEALTH);

        getPosition().setLocation(position);
    }

    public BasicSmallShip(GameLevel level, int x, int y) {
        super(level, BASE_HEALTH);

        setX(x);
        setY(y);

        hitBoxManager = new SimpleHitBoxManager(this);

    }

    public BasicSmallShip(GameLevel level) {
        super(level, BASE_HEALTH);
        this.gun = new Gun(level);

        int yOffset = GameScale.yScale(20);
        setX(Screen.getInstance().getWidth() / 2);
        setY(getHeight() / 2 + yOffset);

        hitBoxManager = new SimpleHitBoxManager(this);
    }

    @Override
    public GraphicsManager getGraphics() {
        return graphicsManager;
    }

    @Override
    public HitBoxManager getHitBoxManager() {
        return hitBoxManager;
    }

    @Override
    public void update() {
        getBehavior().act(this);
    }

    @Override
    public Behavior getBehavior() {
        return behavior;
    }

    public Gun getGun() {
        return gun;
    }
}
