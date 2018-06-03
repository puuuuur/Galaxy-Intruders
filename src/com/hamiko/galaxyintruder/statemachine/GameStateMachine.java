package com.hamiko.galaxyintruder.statemachine;

import com.hamiko.galaxyintruder.input.InputHandler;
import com.hamiko.galaxyintruder.states.GameState;
import com.hamiko.galaxyintruder.states.GameStateFactory;
import com.hamiko.galaxyintruder.window.Screen;

/**
 * Singleton
 */
public class GameStateMachine {

    private static GameStateMachine instance = new GameStateMachine();
    private GameStateFactory factory = new GameStateFactory();
    private GameState activeState = factory.getState(State.GAME_PLAY);

    public static GameStateMachine getInstance() {
        return GameStateMachine.instance;
    }

    public void update(){
        this.activeState.update();
    }

    public GameState getActiveState() {
        return this.activeState;
    }

    InputHandler input;

    public void setActiveState(State gameState) {

        Screen.getInstance().canvas.removeKeyListener(activeState.getInput());
        this.activeState.getInput().resetInput();
        this.activeState = factory.getState(gameState);
        Screen.getInstance().canvas.addKeyListener(activeState.getInput());

        Screen.getInstance().setGameView(activeState.getView());
        //activeState.getView().addKeyListener(activeState.getInput());//TODO add listener only once

    }

}
