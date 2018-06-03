package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.graphics.view.GamePlayView;
import com.hamiko.galaxyintruder.graphics.view.MenuView;
import com.hamiko.galaxyintruder.graphics.view.PauseView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.input.PauseInput;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.statemachine.State;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameStateFactory {

    private Map<State, GameState> statesContainer = new HashMap<>();

    //TODO proper state factory
    public GameState getState(State state) {

        GameState newState = statesContainer.get(state);

        if(newState == null){

            switch (state) {
                case PAUSE:
                    newState = new PauseState(new PauseView(), new PauseInput());
                    break;
                case GAME_PLAY:
                    newState = new GamePlayState(new GamePlayView(), new SpaceShipInput());
                    break;
                case MENU:
                    newState = new MenuState(new MenuView(), new MenuInput());
                    break;
                default:
                    throw new InvalidParameterException(state.toString() + " is not a valid state!");
            }

            statesContainer.put(state, newState);

        }

        return  newState;

        //return new MenuState(new MenuView(), new MenuInput());
      //  return new GamePlayState(new GamePlayView(), new SpaceShipInput());
    }

}
