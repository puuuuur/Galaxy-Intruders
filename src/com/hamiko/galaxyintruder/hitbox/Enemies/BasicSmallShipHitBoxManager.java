package com.hamiko.galaxyintruder.hitbox.Enemies;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.hitbox.HitBoxManager;

public class BasicSmallShipHitBoxManager extends HitBoxManager {

    private Entity entity;

    public BasicSmallShipHitBoxManager(Entity entity) {

        this.entity = entity;
        HitBox box = new HitBox(entity.getPosition(), entity.getWidth(), entity.getHeight());
        hitboxes.add(box);

    }

    @Override
    public Entity getEntity() {
        return entity;
    }

}
