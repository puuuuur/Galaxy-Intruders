package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.entities.Entity;

/**
 * Creates an hitbox around entity width and height
 */
public class SimpleHitBoxManager extends HitBoxManager {

    public SimpleHitBoxManager(Entity entity) {
        super(entity);

        this.entity = entity;
        HitBox box = new HitBox(entity.getPosition(), entity.getWidth(), entity.getHeight());
        hitboxes.add(box);

    }

}
