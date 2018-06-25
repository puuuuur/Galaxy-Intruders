package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.elements.menu.GameOverElements;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class GameOverState extends GameState {

    private MenuInput input;

    public GameOverState(GameView view, MenuInput input) {
        super(view, input);

        this.input = input;
        view.addElements(new GameOverElements(new Position(120, 100)));

    }

    @Override
    public void update() {

        if(input.confirm()){
            GameStateMachine.getInstance().restartGameState();
            GameStateMachine.getInstance().setActiveState(State.MENU);
        }

    }

}
