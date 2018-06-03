package com.hamiko.galaxyintruder.statemachine;

import com.hamiko.galaxyintruder.graphics.view.GamePlayView;
import com.hamiko.galaxyintruder.graphics.view.MenuView;
import com.hamiko.galaxyintruder.graphics.view.PauseView;
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

        statesContainer.put(State.PAUSE, new PauseState(new PauseView(), new PauseInput()));
        statesContainer.put(State.MENU, new MenuState(new MenuView(), new MenuInput()));
        statesContainer.put(State.GAME_PLAY, new GamePlayState(new GamePlayView(), new SpaceShipInput()));

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
        Screen.getInstance().canvas.removeKeyListener(activeState.getInput());
        this.activeState = statesContainer.get(gameState);
        Screen.getInstance().canvas.addKeyListener(activeState.getInput());
        Screen.getInstance().setGameView(activeState.getView());

    }

}
