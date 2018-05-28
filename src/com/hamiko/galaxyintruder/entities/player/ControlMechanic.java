package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.window.Screen;

public class ControlMechanic {

    SpaceShipInput input;
    Player player;

    private int speed = 3;
    private double rightAccel = 1;
    private double leftAccel = 1;

    private int maxSpeed = 5;

    public ControlMechanic(Player player, SpaceShipInput input) {
        this.player = player;
        this.input = input;
    }

    //TODO make this properly
    void handlePlayerMovement(){

        if (input.left() && input.right()) {
            player.setX(player.getX());
            rightAccel = 0;
            leftAccel = 0;
            player.getGraphics().setCurrentSprite(player.getGraphics().getSpriteSheet().getShipDefault());
        } else if ((input.left() || input.right())) {

            if (input.left()) {

                if (leftAccel < maxSpeed) {
                    leftAccel += 0.1d;
                    player.getGraphics().setCurrentSprite(player.getGraphics().getSpriteSheet().getShipLeft());
                }

            } else {
                leftAccel = 0;
            }

            if (input.right()) {

                if (rightAccel < maxSpeed) {
                    rightAccel += 0.1d;
                    player.getGraphics().setCurrentSprite(player.getGraphics().getSpriteSheet().getShipRight());

                }

            } else {
                rightAccel = 0;
            }

            if (input.left()) {

                if (player.getX() > player.getGraphics().getCurrentSprite().getImage().getWidth() / 2) {
                    player.setX(player.getX() - speed - (int) leftAccel);
                } else {
                    player.setX(player.getGraphics().getCurrentSprite().getImage().getWidth() / 2);
                }

            } else if (input.right()) {

                if (player.getX() < Screen.getInstance().getWidth() - player.getGraphics().getCurrentSprite().getImage().getWidth() / 2) {
                    player.setX(player.getX() + speed + (int) rightAccel);
                } else {
                    player.setX(Screen.getInstance().getWidth() - player.getGraphics().getCurrentSprite().getImage().getWidth() / 2);
                }

            }


        } else {
            player.getGraphics().setCurrentSprite(player.getGraphics().getSpriteSheet().getShipDefault());
        }

    }
}
