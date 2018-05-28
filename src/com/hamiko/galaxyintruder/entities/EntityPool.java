package com.hamiko.galaxyintruder.entities;

import java.util.ArrayList;

public class EntityPool<T extends Entity> extends ArrayList<T> {

    private ArrayList<T> kill = new ArrayList<>();

    /**
     * Update all entities and remove killed
     */
    public void update() {

        for (T e : this) {
            e.update();
        }

        for (T e : kill) {
            this.remove(e);
        }

        kill.clear();

    }

    public void kill(T e) {
        kill.add(e);
    }

}
