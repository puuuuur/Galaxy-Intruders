package com.hamiko.galaxyintruder.graphics.elements;

import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.physics.Position;

import java.util.ArrayList;

/**
 * A group of graphics with a shared relative position
 * All elements that are returned by the construct method, will be drawn relative to the super Position member.
 */
public abstract class GraphicsGroup extends GraphicElement {

    private ArrayList<GraphicElement> elements;

    public GraphicsGroup(Position position) {
        super(position);
        elements = this.construct();
    }

    /**
     * Used to populate the elements class variable
     *
     * @return Collection of graphic elements to draw in this group
     */
    public abstract ArrayList<GraphicElement> construct();

    @Override
    public void render(GameGraphics graphics) {

        for (GraphicElement el : elements) {
            el.render(graphics);
        }

    }

}
