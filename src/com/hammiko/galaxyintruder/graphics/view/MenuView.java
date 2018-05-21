package com.hammiko.galaxyintruder.graphics.view;

import com.hammiko.galaxyintruder.graphics.ScaledGraphics;
import com.hammiko.galaxyintruder.input.MenuInput;

import java.awt.*;

public class MenuView extends GameView {

    private Font titleFont;

    public MenuView() {
        titleFont = new Font("TimesRoman", Font.PLAIN, (int)(100 * screen.xScale()));
    }

    @Override
    public void paintComponent(Graphics gx) {

        ScaledGraphics g = new ScaledGraphics(gx);

        g.getGraphics().setFont(titleFont);
        g.drawString("Galaxy Intruders", 200, 150);

        g.getGraphics().setFont(new Font("TimesRoman", Font.PLAIN, (int)(12 * screen.xScale())));
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
