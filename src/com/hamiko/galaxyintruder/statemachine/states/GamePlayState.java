package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.entities.enemies.small.BasicSmallShip;
import com.hamiko.galaxyintruder.entities.player.MainGun;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class GamePlayState extends GameState {

    private GameLevel activeLevel;

    public GamePlayState(GameView view, SpaceShipInput input) {
        super(view, input);

        activeLevel = new GameLevel();
        Player player = new Player(input, activeLevel, new MainGun(input, activeLevel));

        activeLevel.getEnemyPool().add(new BasicSmallShip(activeLevel, new Position(240, 30)));
        activeLevel.getEnemyPool().add(new BasicSmallShip(activeLevel, new Position(170, 30)));
        activeLevel.getEnemyPool().add(new BasicSmallShip(activeLevel, new Position(100, 30)));
        activeLevel.getEnemyPool().add(new BasicSmallShip(activeLevel, new Position(30, 30)));
        activeLevel.setPlayer(player);

        view.addElements(activeLevel);

    }

    @Override
    public void update() {

        SpaceShipInput cont = (SpaceShipInput)this.input;
        if(cont.pause()){
            GameStateMachine.getInstance().setActiveState(State.PAUSE);
        }

        activeLevel.update();
    }

}
