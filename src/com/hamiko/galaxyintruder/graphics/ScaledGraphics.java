package com.hamiko.galaxyintruder.graphics;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.hitbox.HitBox;
import com.hamiko.galaxyintruder.input.InputHandler;
import com.hamiko.galaxyintruder.input.SpaceShipInput;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.window.Screen;

import java.awt.*;

public class ScaledGraphics {

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

    private void renderPivot(Entity entity, Color color) {

        final int pivotLength = 4;
        graphics.setColor(color);

        graphics.drawLine(
                (int) (entity.getX() - pivotLength * GameScale.xScale()),
                entity.getY(),
                (int) (entity.getX() + pivotLength * GameScale.xScale()),
                entity.getY()
        );

        graphics.drawLine(
                entity.getX(),
                (int) (entity.getY() - pivotLength * GameScale.yScale()),
                entity.getX(),
                (int) (entity.getY() + pivotLength * GameScale.yScale())
        );

    }

    private void renderHitBox(Entity entity, Color color) {

        graphics.setColor(color);

        if (entity.getHitBoxManager() == null) {
            return;//TODO remove this after every entity has a hitbox manager
        }

        for (HitBox box : entity.getHitBoxManager().getHitBoxes()) {

            graphics.drawRect(
                    box.getX() - box.getWidth() / 2,
                    box.getY() - box.getWidth() / 2,
                    box.getWidth(),
                    box.getHeight()
            );

        }

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

    private void drawInputDebugger(Graphics g, InputHandler i) {

        SpaceShipInput input = (SpaceShipInput)i;
        g.drawString("Up: " + input.up(), 200, 200);
        g.drawString("Down " +input.down(), 200, 210);
        g.drawString("Confirm: " + input.pause(), 200, 220);
        g.drawString("Left: " + input.left(), 200, 230);

    }

}
