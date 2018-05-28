package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.manager.PlayerGraphics;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.window.Scalable;
import com.hamiko.galaxyintruder.window.Screen;

public class Player extends Entity implements Scalable {

    public static Player global;//Used to display player position for debugging purposes TODO remove after done

    private SpaceShipInput input;
    private PlayerGraphics spriteManager = new PlayerGraphics();
    private ControlMechanic controls;
    private MainGun mainGun;

    public GameLevel level;

    public Player(SpaceShipInput input, MainGun gun) {

        global = this;//TODO remove this after game is done

        this.input = input;
        this.mainGun = gun;
        this.controls  = new ControlMechanic(this, input);
        setX(Screen.getInstance().getWidth() / 2);
        setY(Screen.getInstance().getHeight() - (int) (200 * Screen.getInstance().yScale()));//TODO make this cleaner

    }

    @Override
    public PlayerGraphics getGraphics() {
        return spriteManager;
    }

    public void setInput(SpaceShipInput input) {
        this.input = input;
    }

    public void update() {
        controls.handlePlayerMovement();
        mainGun.fireMainWeapon(this);
    }

    public void addLevel(GameLevel level) {
        this.level = level;
    }

    @Override
    public void scale(double xScale, double yScale) {

    }

}
