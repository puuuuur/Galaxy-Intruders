package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.InputHandler;
import com.hamiko.galaxyintruder.statemachine.State;

public abstract class GameState {

    protected GameView view;
    protected InputHandler input;

    public GameState(GameView view, InputHandler input) {
        this.view = view;
        this.input = input;
    }

    public abstract State getStateName();

    public abstract void update();

    public GameView getView() {
        return view;
    }

    public InputHandler getInput() {
        return input;
    }

}
