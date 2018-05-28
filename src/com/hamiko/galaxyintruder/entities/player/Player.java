package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.projectiles.BasicBullet;
import com.hamiko.galaxyintruder.graphics.handler.PlayerGraphics;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.level.GameLevel;
import com.hamiko.galaxyintruder.window.Screen;

public class Player extends Entity {

    public static Player global;//Used to display player position for debugging purposes

    private SpaceShipInput input;
    private PlayerGraphics spriteManager = new PlayerGraphics();

    private int speed = 3;
    private double rightAccel = 1;
    private double leftAccel = 1;

    private int maxSpeed = 5;
    private int firingSpeed = 45;//60 is one second
    private int fireRouting = 0;

    private GameLevel level;

    public Player() {
        global = this;
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
        handlePlayerMovement();
        fireMainWeapon();
    }

    public void addLevel(GameLevel level) {
        this.level = level;
    }

    protected void handlePlayerMovement() {

        //TODO create velocity simulation
        if (input.left() && input.right()) {
            setX(getX());
            rightAccel = 0;
            leftAccel = 0;
            getGraphics().setCurrentSprite(getGraphics().getSpriteSheet().getShipDefault());
        } else if ((input.left() || input.right())) {

            if (input.left()) {

                if (leftAccel < maxSpeed) {
                    leftAccel += 0.1d;
                    getGraphics().setCurrentSprite(getGraphics().getSpriteSheet().getShipLeft());
                }

            } else {
                leftAccel = 0;
            }

            if (input.right()) {

                if (rightAccel < maxSpeed) {
                    rightAccel += 0.1d;
                    getGraphics().setCurrentSprite(getGraphics().getSpriteSheet().getShipRight());

                }

            } else {
                rightAccel = 0;
            }

            if (input.left()) {

                if (getX() > getGraphics().getCurrentSprite().getImage().getWidth() / 2) {
                    setX(getX() - speed - (int) leftAccel);
                } else {
                    setX(getGraphics().getCurrentSprite().getImage().getWidth() / 2);
                }

            } else if (input.right()) {

                if (getX() < Screen.getInstance().getWidth() - getGraphics().getCurrentSprite().getImage().getWidth() / 2) {
                    setX(getX() + speed + (int) rightAccel);
                } else {
                    setX(Screen.getInstance().getWidth() - getGraphics().getCurrentSprite().getImage().getWidth() / 2);
                }

            }


        } else {
            getGraphics().setCurrentSprite(getGraphics().getSpriteSheet().getShipDefault());
        }

    }

    private void fireMainWeapon() {

        if (input.fire()) {

            if (firingSpeed == fireRouting) {

                BasicBullet bullet = new BasicBullet(
                        getX(),
                        getY() - getGraphics().getCurrentSprite().getImage().getWidth() / 2

                );

                level.addProjectile(bullet);
                fireRouting = 0;

            } else {
                fireRouting++;
            }

        } else {
            fireRouting = 0;
        }

    }

}
