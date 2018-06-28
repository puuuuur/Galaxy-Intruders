package com.hamiko.galaxyintruder.entities.enemies.small;

import com.hamiko.galaxyintruder.ai.BehaviorManager;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.enemies.Gun;
import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;
import com.hamiko.galaxyintruder.hitbox.SimpleHitBoxManager;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.Position;

public class BasicSmallShip extends Enemy {

    private GraphicsManager graphicsManager;
    private BehaviorManager behavior;
    private SimpleHitBoxManager hitBoxManager;
    private Gun gun;

    private static final int BASE_HEALTH = 30;

    public BasicSmallShip(GameLevel level, Position position) {
        super(level, BASE_HEALTH * level.getDifficultyScale());

        graphicsManager = new BasicSmallShipGraphics();
        behavior = new BehaviorManager();
        this.behavior.addAct(new BasicSmallShipAI());
        this.gun = new Gun(level);

        getPosition().setLocation(position);
        hitBoxManager = new SimpleHitBoxManager(this);

    }

    Gun getGun() {
        return gun;
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
    public BehaviorManager getBehavior() {
        return behavior;
    }

    @Override
    public int getPoints() {
        return 100;
    }

}
