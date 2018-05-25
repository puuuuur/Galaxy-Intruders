package com.hamiko.galaxyintruder.entities.player;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.graphics.handler.GraphicsManager;
import com.hamiko.galaxyintruder.graphics.handler.PlayerGraphics;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.window.Screen;

public class Player extends Entity {

    private SpaceShipInput input;
    private GraphicsManager spriteManager = new PlayerGraphics();
    private int speed = 3;
    private double rightAccel = 1;
    private double leftAccel = 1;

    private int maxSpeed = 5;
    private int firingSpeed = 45;//60 is one second
    private int fireRouting = 0;

    public Player(){
        setX(Screen.getInstance().getWidth() / 2);
        setY(Screen.getInstance().getHeight() - (int)(200 * Screen.getInstance().yScale()));//TODO make this cleaner
    }
    public GraphicsManager getGraphics() {
        return spriteManager;
    }

    public void setInput(SpaceShipInput input) {
        this.input = input;
    }

    boolean left = false;
    boolean right = false;

    public void update() {

        //TODO input handling 2.0, if a direction is pressed, prevent other direction. FIFS (first in, first served)
        //TODO reset rightAccel, or better, make velocity simulation

        if(input.left() && input.right()){
            setX(getX());
            rightAccel = 0;
            leftAccel = 0;
        }else{

            if(input.left()){
                if(leftAccel < maxSpeed) leftAccel += 0.1d;
            }else {
                leftAccel = 0;
            }

            if(input.right()){
                if(rightAccel < maxSpeed) rightAccel += 0.1d;
            }else {
                rightAccel = 0;
            }

            if (input.left()) {


                if(getX() > 0)
                setX(getX() - speed - (int) leftAccel);
            } else if (input.right()) {
                System.out.println(getGraphics().getCurrentSprite().getImage().getWidth() * 4);
                if(getX() < Screen.Constant.BASE_WIDTH - getGraphics().getCurrentSprite().getImage().getWidth()* 4)
                setX(getX() + speed + (int) rightAccel);
            }


        }

        if (input.fire()) {
            //TODO firing speed

            if(firingSpeed == fireRouting){
                System.out.println("Shoot");
                fireRouting = 0;
            }else{
                fireRouting++;
            }

        }else {
            fireRouting = 0;
        }

    }

}
