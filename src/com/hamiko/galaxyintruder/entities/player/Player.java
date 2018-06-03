package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.graphics.manager.PlayerGraphics;
import com.hamiko.galaxyintruder.hitbox.PlayerHitBoxManager;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.graphics.window.Screen;

public class Player extends SpaceShip {

    public static Player global;//Used to display player position for debugging purposes TODO remove after done

    private PlayerGraphics spriteManager = new PlayerGraphics();
    private ControlMechanic controls;
    private MainGun mainGun;
    private PlayerHitBoxManager hitbox;

    public GameLevel level;

    public Player(SpaceShipInput input, GameLevel level, MainGun gun) {
        super(level, 200);
        global = this;//TODO remove this after game is done

        this.mainGun = gun;
        this.controls = new ControlMechanic(this, input);

//        final int startOffset = GameScale.yScale(20);
        final int startOffset = GameScale.yScale(10) + getHeight() / 2;

        int xPos = Screen.getInstance().getCanvasSize().width / 2;
        int yPos = Screen.getInstance().getCanvasSize().height - startOffset;//TODO Init player position in level

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

            System.out.println("TRIGGER GAME OVER");
            //TODO tell the level that a game over has occurred

        }

    }

}
