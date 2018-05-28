package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class HitBoxManager {

    protected ArrayList<HitBox> hitboxes = new ArrayList<>();

    protected Entity entity;

    public List<HitBox> getHitBoxes() {
        return hitboxes;
    }

    public void update() {

        for (HitBox box : hitboxes) {
            box.getPosition().translate(getEntity().getX() - box.getPosition().x, getEntity().getY() - box.getPosition().y);
        }

    }

    public Entity getEntity(){
        return entity;
    }

}
