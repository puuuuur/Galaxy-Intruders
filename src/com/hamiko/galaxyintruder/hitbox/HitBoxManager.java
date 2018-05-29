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

            box.getPosition().translate(
                    getEntity().getX() - box.getPosition().x + box.getOffsetX(),
                    getEntity().getY() - box.getPosition().y + box.getOffsetY()
            );

            /*
             *NOTES on making this work
             * 1. keep as is, with offset set, is kinda hardcoded but works well enough
             * 2. create an interface for the hit box position
             *   a. the interface should have two methods that return an integer
             *   b. the method parameter should be the entity from witch we will calculate our new position
             *   b. in the methods we define how to calculate the exact position we want
             */

        }

    }

    public Entity getEntity() {
        return entity;
    }

}
