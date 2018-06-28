package com.hamiko.galaxyintruder.ai;

import com.hamiko.galaxyintruder.entities.SpaceShip;
import java.util.ArrayList;
import java.util.List;

public class BehaviorManager {

    private List<Behavior> acts = new ArrayList<>();

    public void act(SpaceShip ship) {

        for (Behavior b: acts) {
            b.act(ship);
        }

    }

    public void addAct(Behavior act) {
        this.acts.add(act);
    }

}
