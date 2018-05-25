package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.window.Screen;

import java.awt.*;
import java.awt.image.BufferedImage;

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
        BufferedImage image = entity.getGraphics().getCurrentSprite().getImage();
        graphics.drawImage(image, entity.getX(), entity.getY(), (int)(image.getWidth() * screen.xScale()), (int)(image.getHeight() * screen.yScale()), screen);
    }

}
