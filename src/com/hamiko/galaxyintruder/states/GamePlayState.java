package com.hamiko.galaxyintruder.states;

import com.hamiko.galaxyintruder.entities.enemies.BasicSmallShip;
import com.hamiko.galaxyintruder.entities.player.MainGun;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.graphics.view.GamePlayView;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.statemachine.State;

public class GamePlayState extends GameState {

    private GamePlayView view;
    private Player player;
    private GameLevel activeLevel;

    public GamePlayState(GamePlayView view, SpaceShipInput input) {
        super(view, input);

        activeLevel = new GameLevel();
        player = new Player(input, new MainGun(input, activeLevel));
        BasicSmallShip ship = new BasicSmallShip();

        activeLevel.getEnemyPool().add(ship);

        activeLevel.setPlayer(player);

        player.addLevel(activeLevel);

        this.view = view;
        this.view.setLevel(activeLevel);

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
