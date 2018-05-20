package com.hammiko.galaxyintruder.statemachine;

import com.hammiko.galaxyintruder.states.GameState;
import com.hammiko.galaxyintruder.states.GameStateFactory;

/**
 * Singleton
 */
public class GameStateMachine {

    private static GameStateMachine instance = null;
    private GameState activeState = new GameStateFactory().create();

    public static GameStateMachine getInstance() {

        if (GameStateMachine.instance == null) {
            GameStateMachine.instance = new GameStateMachine();
        }

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
