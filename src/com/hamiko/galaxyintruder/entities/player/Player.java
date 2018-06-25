package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.graphics.manager.PlayerGraphics;
import com.hamiko.galaxyintruder.hitbox.PlayerHitBoxManager;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.graphics.window.Screen;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;
import com.hamiko.galaxyintruder.statemachine.states.GameOverState;

public class Player extends SpaceShip {

    private PlayerGraphics spriteManager = new PlayerGraphics();
    private ControlMechanic controls;
    private MainGun mainGun;
    private PlayerHitBoxManager hitBox;

    public Player(SpaceShipInput input, GameLevel level, MainGun gun) {

        super(level, 50);

        this.mainGun = gun;
        this.mainGun.setOffsetY(-this.getHeight() / 2);

        this.controls = new ControlMechanic(this, input);

        final int startOffset = GameScale.yScale(10) + getHeight() / 2;

        int xPos = Screen.getInstance().getCanvas().getWidth() / 2;
        int yPos = Screen.getInstance().getCanvas().getHeight() - startOffset;//TODO Init player position in scenes

        setX(xPos);
        setY(yPos);

        this.hitBox = new PlayerHitBoxManager(this);

    }

    @Override
    public PlayerHitBoxManager getHitBoxManager() {
        return hitBox;
    }

    @Override
    public PlayerGraphics getGraphics() {
        return spriteManager;
    }

    public void update() {
        controls.handlePlayerMovement();
        mainGun.update(this);
    }

    @Override
    public void takeDamage(int dmg) {

        super.takeDamage(dmg);

        if (getHealth() <= 0) {
            ((GameOverState) GameStateMachine.getInstance().getState(State.GAME_OVER)).setScore(this.level.getScorePanel().getScore());
            GameStateMachine.getInstance().setActiveState(State.GAME_OVER);
        }

    }

}
