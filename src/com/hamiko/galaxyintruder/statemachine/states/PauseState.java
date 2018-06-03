package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.view.PauseView;
import com.hamiko.galaxyintruder.input.PauseInput;
import com.hamiko.galaxyintruder.statemachine.State;

public class PauseState extends GameState {

    public PauseState(PauseView view, PauseInput input) {
        super(view, input);
    }

    @Override
    public State getStateName() {
        return State.PAUSE;
    }

    @Override
    public void update() {
        System.out.println("Paused");
    }

}
