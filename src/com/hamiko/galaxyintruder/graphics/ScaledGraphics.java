package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.physics.GameScale;
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
        graphics.drawString(str, (int) (x * GameScale.xScale()), (int) (y * GameScale.yScale()));
    }

    public void drawEntity(Entity entity) {

        graphics.drawImage(
                entity.getGraphics().getCurrentSprite().getImage(),
                entity.getX() - entity.getWidth() / 2,
                entity.getY() - entity.getHeight() / 2,
                entity.getWidth(),
                entity.getHeight(),
                screen
        );

        renderHitBox(entity, Color.yellow);
        //drawBorder(entity, Color.GREEN);
        renderPivot(entity, Color.RED);

    }

    public void drawBorder(Entity entity, Color color) {

        graphics.setColor(color);

        graphics.drawRect(
                entity.getX() - entity.getWidth() / 2,
                entity.getY() - entity.getHeight() / 2,
                entity.getWidth(),
                entity.getHeight()
        );

    }

    private void renderPivot(Entity entity, Color color) {

        final int pivotLength = 4;
        graphics.setColor(color);
        
        graphics.drawLine(
                (int)(entity.getX() - pivotLength * GameScale.xScale()),
                entity.getY(),
                (int)(entity.getX() + pivotLength * GameScale.xScale()),
                entity.getY()
        );

        graphics.drawLine(
                entity.getX(),
                (int)(entity.getY() - pivotLength * GameScale.yScale()),
                entity.getX(),
                (int)(entity.getY() + pivotLength * GameScale.yScale())
        );

    }

    private void renderHitBox(Entity entity, Color color){

        graphics.setColor(color);

        if(entity.getHitBoxManager() == null){
            return;//TODO remove this after every entity has a hitbox manager
        }

        for (HitBox box: entity.getHitBoxManager().getHitBoxes() ) {

            graphics.drawRect(
                    box.getX() - box.getWidth() / 2,
                    box.getY() - box.getWidth() / 2,
                    box.getWidth(),
                    box.getHeight()
            );

        }

    }

}
