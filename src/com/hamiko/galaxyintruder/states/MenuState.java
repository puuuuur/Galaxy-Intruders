package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.graphics.view.MenuView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class MenuState extends GameState {

    public MenuState(MenuView view, MenuInput input) {
        super(view, input);
    }

    @Override
    public State getStateName() {
        return State.MENU;
    }

    @Override
    public void update() {

        MenuInput cont = (MenuInput) this.input;
        if(cont.cancel()){
            GameStateMachine.getInstance().setActiveState(State.GAME_PLAY);
        }

    }

}
