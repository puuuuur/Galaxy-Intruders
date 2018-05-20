package com.hammiko.galaxyintruder.states;

import com.hammiko.galaxyintruder.graphics.view.PauseView;
import com.hammiko.galaxyintruder.input.PauseInput;
import com.hammiko.galaxyintruder.statemachine.State;

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
