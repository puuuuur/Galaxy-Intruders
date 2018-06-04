package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.PauseInput;

public class PauseState extends GameState {

    public PauseState(GameView view, PauseInput input) {
        super(view, input);
    }

    @Override
    public void update() {
        System.out.println("Paused");
    }

}
