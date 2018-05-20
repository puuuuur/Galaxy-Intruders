package com.hammiko.galaxyintruder.states;

import com.hammiko.galaxyintruder.graphics.view.MenuView;
import com.hammiko.galaxyintruder.input.MenuInput;
import com.hammiko.galaxyintruder.statemachine.State;

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
