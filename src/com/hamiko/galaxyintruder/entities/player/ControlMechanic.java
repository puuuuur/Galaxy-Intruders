package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.graphics.animation.PlayerAnimation;
import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.sprite.Sprite;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.graphics.window.Screen;

public class ControlMechanic {

    private SpaceShipInput input;
    private Player player;

    private int speed = GameScale.xScale(3);
    private int baseSpeed = speed;
    private double rightAccel = 1;
    private double leftAccel = 1;
    private double accelFactor = 0.001d;

    private int maxSpeed = 5;

    private Sprite playerLeft;
    private PlayerAnimation animation;

    public ControlMechanic(Player player, SpaceShipInput input) {

        this.player = player;
        this.input = input;
        //TODO show sprites with animation manager

        animation = player.getGraphics().getAnimations();
        playerLeft = new Sprite(ImageRefactor.flipHorizontally(player.getGraphics().getSpriteSheet().getSprite(0, 1).getImage()));

    }

    void handlePlayerMovement() {

        speed *= GameScale.interpolation();

        if (input.left() && input.right()) {

            player.setX(player.getX());
            rightAccel = 0;
            leftAccel = 0;
            animation.animateCenter();

        } else if ((input.left() || input.right())) {


            if (input.left()) {

                if (leftAccel < maxSpeed) {
                    leftAccel += accelFactor;
                    animation.animateLeft();
                }

            } else {
                leftAccel = 0;
            }

            if (input.right()) {

                if (rightAccel < maxSpeed) {
                    rightAccel += accelFactor;
                    animation.animateRight();
                }

            } else {
                rightAccel = 0;
            }

            if (input.left()) {

                if (player.getX() > player.getWidth() / 2) {
                    player.setX(player.getX() - speed - (int) leftAccel);
                } else {
                    player.setX(player.getWidth() / 2);
                }

            } else if (input.right()) {

                // TODO hit collision should probably not be here
                if (player.getX() < Screen.getInstance().getWidth() - player.getWidth() / 2) {
                    player.setX(player.getX() + speed + (int) rightAccel);
                } else {
                    player.setX(Screen.getInstance().getWidth() - player.getWidth() / 2);
                }

            }

        } else {
            animation.animateCenter();
        }

        speed = baseSpeed;

    }

}
