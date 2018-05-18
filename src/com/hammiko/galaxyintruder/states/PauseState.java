package com.hammiko.galaxyintruder.states;

import com.hammiko.galaxyintruder.statemachine.State;

public class PauseState extends GameState {

    @Override
    public State getStateName() {
        return State.PAUSE;
    }

    @Override
    public void update() {
        System.out.println("Paused");
    }

    @Override
    public void render() {
        System.out.println("Paused render");
    }

}
