package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.window.Screen;

import java.awt.*;

public class ScaledGraphics {

    private Graphics2D graphics;
    private Screen screen = Screen.getInstance();

    public ScaledGraphics(Graphics graphics) {
        this.graphics = (Graphics2D) graphics;
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public void drawString(String str, int x, int y) {
        graphics.drawString(str, (int) (x * screen.xScale()), (int) (y * screen.yScale()));
    }

    //TODO delegate drawEntity in two variants, absolute and relative
    public void drawEntity(Entity entity){
        graphics.drawImage(entity.getGraphics().getCurrentSprite().getImage(), entity.getX(), entity.getY(), 100, 100, screen);
    }

}
