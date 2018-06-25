package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.elements.menu.GameOverElements;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class GameOverState extends GameState {

    private MenuInput input;
    private GameOverElements labels;
    private double inputTimer = 0;

    public GameOverState(GameView view, MenuInput input) {
        super(view, input);

        this.input = input;
        this.labels = new GameOverElements(new Position(120, 100));
        view.addElements(this.labels);

    }

    @Override
    public void update() {

        inputTimer += 1;

        if (input.confirm() && inputTimer / 60 >= 1.5) {
            inputTimer = 0;
            GameStateMachine.getInstance().restartGameState();
            GameStateMachine.getInstance().setActiveState(State.MENU);
        }

    }

    public void setScore(int score) {
        this.labels.setScore(score);
    }

}
