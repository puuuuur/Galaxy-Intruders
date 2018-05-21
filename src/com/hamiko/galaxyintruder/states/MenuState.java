package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.graphics.view.MenuView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.statemachine.State;

public class MenuState extends GameState{

    public MenuState(MenuView view, MenuInput input) {
        super(view, input);
    }

    @Override
    public State getStateName() {
        return State.MENU;
    }

    @Override
    public void update() {
        this.view.update();
        ((MenuView)this.view).printInput((MenuInput) input);
    }

}
