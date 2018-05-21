package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.window.Screen;

import java.awt.*;

public class ScaledGraphics {

    private Graphics2D graphics;
    private Screen screen = Screen.getInstance();

    public ScaledGraphics(Graphics graphics) {
        this.graphics = (Graphics2D) graphics;
    }

    public void drawString(String str, int x, int y) {
        graphics.drawString(str, (int) (x * screen.xScale()), (int) (y * screen.yScale()));
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    //TODO delegate drawImage in two variants, absolute and relative
    //TODO NOTE: Give draw image an entity instead
    public void drawImage(){
        //graphics.drawImage();
    }

}
