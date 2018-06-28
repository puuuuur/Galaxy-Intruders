package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.entities.player.MainGun;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class GamePlayState extends GameState {

    private GameLevel activeLevel;

    public GamePlayState(GameView view, SpaceShipInput input) {
        super(view, input);

        activeLevel = new GameLevel();
        activeLevel.setPlayer(new Player(input, activeLevel, new MainGun(input, activeLevel)));
        view.addElements(activeLevel);

    }

    @Override
    public void update() {

        updateRoutines();
        SpaceShipInput controls = (SpaceShipInput) this.input;

        if (controls.pause()) {
            GameStateMachine.getInstance().setActiveState(State.PAUSE);
        }

        activeLevel.update();
    }

}
