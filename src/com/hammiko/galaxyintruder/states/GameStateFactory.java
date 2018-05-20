package com.hammiko.galaxyintruder.states;

import com.hammiko.galaxyintruder.graphics.view.MenuView;
import com.hammiko.galaxyintruder.input.MenuInput;

public class GameStateFactory {

    //TODO proper state factory
    public GameState create(){
        return new MenuState(new MenuView(), new MenuInput());
    }

}
