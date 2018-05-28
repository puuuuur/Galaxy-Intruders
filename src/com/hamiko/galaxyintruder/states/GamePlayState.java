package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.entities.projectiles.BasicBullet;
import com.hamiko.galaxyintruder.graphics.view.GamePlayView;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.statemachine.State;

public class GamePlayState extends GameState {

    private SpaceShipInput input;
    private GamePlayView view;
    private Player player;
    private GameLevel activeLevel;

    public GamePlayState(GamePlayView view, SpaceShipInput input) {
        super(view, input);

        player = new Player();
        player.setInput(input);

        activeLevel = new GameLevel();
        activeLevel.setPlayer(player);

        player.addLevel(activeLevel);

        this.view = view;
        this.view.setLevel(activeLevel);
        this.input = input;
    }

    @Override
    public State getStateName() {
        return State.GAME_PLAY;
    }

    @Override
    public void update() {
        activeLevel.update();
    }

}
