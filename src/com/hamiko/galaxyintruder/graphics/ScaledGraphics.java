package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.hitbox.HitBox;
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

    public void drawEntity(Entity entity) {

        BufferedImage image = entity.getGraphics().getCurrentSprite().getImage();

        graphics.drawImage(
                image,
                entity.getX() - image.getWidth() / 2,
                entity.getY() - image.getHeight() / 2,
                (int) (image.getWidth() * screen.xScale()),
                (int) (image.getHeight() * screen.yScale()),
                screen
        );

        renderHitbox(entity, Color.yellow);
       // drawBorder(entity, image, Color.GREEN);
        renderPivot(entity, Color.RED);

    }

    public void drawBorder(Entity entity, BufferedImage image, Color color) {

        graphics.setColor(color);

        graphics.drawRect(
                entity.getX() - image.getWidth() / 2,
                entity.getY() - image.getHeight() / 2,
                image.getWidth(),
                image.getHeight()
        );

    }

    public void renderPivot(Entity entity, Color color) {

        graphics.setColor(color);
        
        graphics.drawLine(
                (int)(entity.getX() - 10 * screen.xScale()),
                entity.getY(),
                (int)(entity.getX() + 10 * screen.xScale()),
                entity.getY()
        );

        graphics.drawLine(
                entity.getX(),
                (int)(entity.getY() - 10 * screen.yScale()),
                entity.getX(),
                (int)(entity.getY() + 10 * screen.yScale())
        );

    }

    public void renderHitbox(Entity entity, Color color){

        graphics.setColor(color);

        if(entity.getHitBoxManager() == null){
            return;//TODO remove this after every entity has a hitbox manager
        }

        for (HitBox box: entity.getHitBoxManager().getHitBoxes() ) {

            graphics.drawRect(
                    box.getPosition().x - box.getWidth() / 2,
                    box.getPosition().y - box.getWidth() / 2,
                    box.getWidth(),
                    box.getHeight()
            );

        }

    }

}
