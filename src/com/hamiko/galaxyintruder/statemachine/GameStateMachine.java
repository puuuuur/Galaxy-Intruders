package com.hamiko.galaxyintruder.statemachine;

import com.hamiko.galaxyintruder.states.GameState;
import com.hamiko.galaxyintruder.states.GameStateFactory;

/**
 * Singleton
 */
public class GameStateMachine {

    private static GameStateMachine instance = new GameStateMachine();
    private GameState activeState = new GameStateFactory().create();

    public static GameStateMachine getInstance() {
        return GameStateMachine.instance;
    }

    public void update(){
        this.activeState.update();
    }

    public GameState getActiveState() {
        return this.activeState;
    }

    public void changeState(GameState gameState) {
        this.activeState = gameState;
    }

}
