package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.manager.PlayerGraphics;
import com.hamiko.galaxyintruder.hitbox.PlayerHitBoxManager;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.window.Screen;

public class Player extends Entity {

    public static Player global;//Used to display player position for debugging purposes TODO remove after done

    private PlayerGraphics spriteManager = new PlayerGraphics();
    private ControlMechanic controls;
    private MainGun mainGun;
    private PlayerHitBoxManager hitbox;

    public GameLevel level;

    public Player(SpaceShipInput input, MainGun gun) {

        global = this;//TODO remove this after game is done

        this.mainGun = gun;
        this.controls = new ControlMechanic(this, input);

        final int startOffset = getHeight() / 2;

        int xPos = Screen.getInstance().getWidth() / 2;
        int yPos = Screen.getInstance().getHeight() - startOffset;

        setX(xPos);
        setY(yPos);//TODO make this cleaner

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

    public void addLevel(GameLevel level) {
        this.level = level;
    }

}
