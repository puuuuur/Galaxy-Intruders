package com.hamiko.galaxyintruder.statemachine;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.input.PauseInput;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.statemachine.states.*;
import com.hamiko.galaxyintruder.graphics.window.Screen;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton
 */
public class GameStateMachine {

    private static GameStateMachine instance = new GameStateMachine();
    private GameState activeState;

    private Map<State, GameState> statesContainer = new HashMap<>();

    private GameStateMachine() {

        statesContainer.put(State.PAUSE, new PauseState(new GameView(), new PauseInput()));
        statesContainer.put(State.MENU, new MenuState(new GameView(), new MenuInput()));
        statesContainer.put(State.GAME_PLAY, new GamePlayState(new GameView(), new SpaceShipInput()));

        this.activeState = statesContainer.get(State.MENU);

    }

    public static GameStateMachine getInstance() {
        return GameStateMachine.instance;
    }

    public void update() {
        this.activeState.update();
    }

    public void setActiveState(State gameState) {

        this.activeState.getInput().resetInput();

        //TODO Proper key listener handling
        //IDEA: keep th same input, just change the map
        Screen.getInstance().getCanvas().removeKeyListener(activeState.getInput());
        this.activeState = statesContainer.get(gameState);
        Screen.getInstance().getCanvas().addKeyListener(activeState.getInput());
        Screen.getInstance().setGameView(activeState.getView());

    }

}
