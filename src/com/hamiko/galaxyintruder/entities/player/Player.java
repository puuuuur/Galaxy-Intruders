package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.graphics.manager.PlayerGraphics;
import com.hamiko.galaxyintruder.hitbox.PlayerHitBoxManager;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.graphics.window.Screen;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class Player extends SpaceShip {

    private PlayerGraphics spriteManager = new PlayerGraphics();
    private ControlMechanic controls;
    private MainGun mainGun;
    private PlayerHitBoxManager hitbox;

    public Player(SpaceShipInput input, GameLevel level, MainGun gun) {

        super(level, 10);

        this.mainGun = gun;
        this.controls = new ControlMechanic(this, input);

        final int startOffset = GameScale.yScale(10) + getHeight() / 2;

        int xPos = Screen.getInstance().getCanvas().getWidth() / 2;
        int yPos = Screen.getInstance().getCanvas().getHeight() - startOffset;//TODO Init player position in scenes

        setX(xPos);
        setY(yPos);

        this.hitbox = new PlayerHitBoxManager(this);

    }

    @Override
    public PlayerHitBoxManager getHitBoxManager() {
        return hitbox;
    }

    @Override
    public PlayerGraphics getGraphics() {
        return spriteManager;
    }

    public void update() {
        controls.handlePlayerMovement();
        mainGun.fireMainWeapon(this);
    }

    @Override
    public void takeDamage(int dmg) {

        super.takeDamage(dmg);

        if (getHealth() <= 0) {

            GameStateMachine.getInstance().setActiveState(State.GAME_OVER);
            //TODO tell the scenes that a game over has occurred

        }

    }

}
