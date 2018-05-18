package com.hammiko.galaxyintruder.statemachine;

import com.hammiko.galaxyintruder.states.GameState;
import com.hammiko.galaxyintruder.states.MenuState;

/**
 * Singleton
 */
public class GameStateMachine {

    private static GameStateMachine instance = null;
    private GameState activeState;

    private GameStateMachine(GameState startState) {
        activeState = startState;
    }

    public static GameStateMachine getInstance() {

        if (GameStateMachine.instance == null) {
            GameStateMachine.instance = new GameStateMachine(new MenuState());
        }

        return GameStateMachine.instance;

    }

    public GameState getActiveState() {
        return this.activeState;
    }

    public void changeState(GameState gameState) {
        this.activeState = gameState;
    }


}
