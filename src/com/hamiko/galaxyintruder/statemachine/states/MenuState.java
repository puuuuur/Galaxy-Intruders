package com.hamiko.galaxyintruder.statemachine.states;

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

        MenuInput controls = (MenuInput) this.input;
        if(controls.cancel()){
            GameStateMachine.getInstance().setActiveState(State.GAME_PLAY);
        }else if(controls.up()){

        }else if(controls.down()){

        }

    }

}
