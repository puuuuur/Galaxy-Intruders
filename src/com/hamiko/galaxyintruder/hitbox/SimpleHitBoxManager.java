package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.entities.Entity;

public class SimpleHitBoxManager extends HitBoxManager{


    public SimpleHitBoxManager(Entity entity) {

        this.entity = entity;
        HitBox box = new HitBox(entity.getPosition(), entity.getWidth(), entity.getHeight());
        hitboxes.add(box);

    }
}
