package com.hammiko.galaxyintruder.states;

import com.hammiko.galaxyintruder.graphics.GameView;
import com.hammiko.galaxyintruder.statemachine.State;

public abstract class GameState {

    protected GameView view;
    public abstract State getStateName();
    public abstract void update();
    public abstract void render();

    public GameView getView() {
        return view;
    }
}
