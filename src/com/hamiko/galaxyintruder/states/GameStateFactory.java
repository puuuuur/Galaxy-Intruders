package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.graphics.view.GamePlayView;
import com.hamiko.galaxyintruder.input.SpaceShipInput;

public class GameStateFactory {

    //TODO proper state factory
    public GameState create(){
        //return new MenuState(new MenuView(), new MenuInput());
        return new GamePlayState(new GamePlayView(), new SpaceShipInput());
    }

}
