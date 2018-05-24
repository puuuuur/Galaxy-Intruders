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

    public void update() {

        if (input.left()) {
            setX(getX() - speed);
        } else if (input.right()) {
            setX(getX() + speed);
        }

        if (input.fire()) {
            System.out.println("Shooting");
        }

    }

}
