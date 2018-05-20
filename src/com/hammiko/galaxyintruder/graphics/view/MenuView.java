package com.hammiko.galaxyintruder.graphics.view;

import com.hammiko.galaxyintruder.input.MenuInput;

import java.awt.*;

public class MenuView extends GameView {

    Graphics2D graphic;

    private String key;

    @Override
    public void paintComponent(Graphics g) {
        //graphic = (Graphics2D) g;

        g.drawString("Counter is: " + counter, 200, 190);
        g.drawString("Counter is: " + counter, 200, 190);
        g.drawString("Up: " + input.up(), 200, 200);
        g.drawString("Down " +input.down(), 200, 210);
        g.drawString("Confirm: " + input.confirm(), 200, 220);
        g.drawString("Cancel: " + input.cancel(), 200, 230);
    }

    public void update() {
        counter++;
    }

    private int counter = 0;

    private MenuInput input;

    public void printInput(MenuInput input) {
        this.input = input;
    }

}
