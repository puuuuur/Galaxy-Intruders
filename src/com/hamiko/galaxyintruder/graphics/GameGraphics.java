package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.graphics.background.Background;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.graphics.window.Screen;

import java.awt.*;

public class GameGraphics {

    private Graphics2D graphics;
    private Screen screen = Screen.getInstance();

    public void setGraphics(Graphics graphics) {
        this.graphics = (Graphics2D) graphics;
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public void drawString(String str, int x, int y) {
        graphics.drawString(str, GameScale.xScale(x), GameScale.yScale(y));
    }

    public void drawSpaceShip(SpaceShip ship) {
        drawEntity(ship);
        drawHealthBar(ship);
    }

    public void drawProjectile(Projectile p) {
        drawEntity(p);
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
        renderPivot(entity, Color.RED);
        //drawBorder(entity, Color.GREEN);

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

    public void drawBackground(Background background){

        graphics.drawImage(
                background.getImage(),
                background.getPosition().x,
                background.getPosition().y,
                background.getImage().getWidth(),
                background.getImage().getHeight(),
                screen
        );

    }

    private void drawHealthBar(SpaceShip ship) {

        if (ship.isDamaged()) {

            //RED
            graphics.setColor(Color.RED);
            graphics.fillRect(
                    ship.getX() - ship.getWidth() / 2,
                    ship.getY() - (int) (ship.getHeight() * .6d),
                    ship.getWidth(),
                    GameScale.yScale(2)
            );

            //GREEN
            graphics.setColor(Color.GREEN);
            graphics.fillRect(
                    ship.getX() - ship.getWidth() / 2,
                    ship.getY() - (int) (ship.getHeight() * .6d),
                    ship.getWidth() * ship.getHealth() / ship.getMaxHealth(),
                    GameScale.yScale(2)
            );

        }

    }

    private void renderPivot(Entity entity, Color color) {

        final int pivotLengthX = GameScale.xScale(4);
        final int pivotLengthY = GameScale.yScale(4);

        graphics.setColor(color);

        graphics.drawLine(
                entity.getX() - pivotLengthX,
                entity.getY(),
                entity.getX() + pivotLengthX,
                entity.getY()
        );

        graphics.drawLine(
                entity.getX(),
                entity.getY() - pivotLengthY,
                entity.getX(),
                entity.getY() + pivotLengthY
        );

    }

    private void renderHitBox(Entity entity, Color color) {

        graphics.setColor(color);

        for (HitBox box : entity.getHitBoxManager().getHitBoxes()) {

            graphics.drawRect(
                    box.getX() - box.getWidth() / 2,
                    box.getY() - box.getWidth() / 2,
                    box.getWidth(),
                    box.getHeight()
            );

        }

    }

}
