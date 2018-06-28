package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class HitBoxManager {

    protected ArrayList<HitBox> hitboxes = new ArrayList<>();

    protected Entity entity;

    public HitBoxManager(Entity entity) {
        this.entity = entity;
    }

    public List<HitBox> getHitBoxes() {
        return hitboxes;
    }

}
