package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.graphics.view.MenuView;
import com.hamiko.galaxyintruder.input.MenuInput;

public class GameStateFactory {

    //TODO proper state factory
    public GameState create(){
        return new MenuState(new MenuView(), new MenuInput());
    }

}
