package com.hamiko.galaxyintruder.graphics.GUI;

import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.elements.GraphicElement;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;

import java.awt.*;

public class MenuCursor extends GraphicElement {

    private Polygon shape;
    private Color color = Color.WHITE;
    private Position oldPosition;

    public MenuCursor(Position position, Position relativePosition) {
        super(position, relativePosition);

        oldPosition = new Position(position);
        this.shapePolygon();
    }

    public MenuCursor(Position position) {
        super(position);
        this.shapePolygon();
    }

    private void shapePolygon(){

        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        xPoints[0] = getPosition().x;
        yPoints[0] = getPosition().y;

        xPoints[1] = getPosition().x;
        yPoints[1] = getPosition().y + GameScale.yScale(10);

        xPoints[2] = getPosition().x + GameScale.xScale(8);
        yPoints[2] = getPosition().y + GameScale.yScale(5);

        shape = new Polygon(xPoints, yPoints, 3);

    }

    @Override
    public void render(GameGraphics gg) {

        if(!oldPosition.equals(getPosition())){
            shapePolygon();
            oldPosition.setLocation(getPosition());
        }

        gg.getGraphics().setColor(color);
        gg.getGraphics().drawPolygon(shape);
        gg.getGraphics().fillPolygon(shape);

    }

}
