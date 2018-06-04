package com.hamiko.galaxyintruder.graphics.elements;

import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.physics.Position;

import java.awt.*;

public abstract class GraphicElement implements Drawable {

    private Position position;

    public GraphicElement(Position position, Position relativePosition){

        position.setLocation(
                position.x + relativePosition.x,
                position.y + relativePosition.y
        );

        this.position = position;

    }

    public GraphicElement(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
