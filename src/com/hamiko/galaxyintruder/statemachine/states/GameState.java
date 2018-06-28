package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.InputHandler;
import com.hamiko.galaxyintruder.statemachine.Routine;

import java.util.ArrayList;
import java.util.List;

public abstract class GameState {

    protected List<Routine> routines;
    protected GameView view;
    protected InputHandler input;

    public GameState(GameView view, InputHandler input) {
        this.view = view;
        this.input = input;
        this.routines = new ArrayList<>();
    }

    public abstract void update();

    public GameView getView() {
        return view;
    }

    public InputHandler getInput() {
        return input;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void addRoutine(Routine r) {
        routines.add(r);
    }

    public void updateRoutines(){
        routines.forEach(Routine::perform);
    }

}
