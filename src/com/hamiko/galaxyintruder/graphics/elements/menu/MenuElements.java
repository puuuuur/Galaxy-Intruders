package com.hamiko.galaxyintruder.graphics.elements.menu;

import com.hamiko.galaxyintruder.graphics.GUI.GraphicText;
import com.hamiko.galaxyintruder.graphics.elements.GraphicElement;
import com.hamiko.galaxyintruder.graphics.elements.GraphicsGroup;
import com.hamiko.galaxyintruder.physics.Position;

import java.util.ArrayList;

public class MenuElements extends GraphicsGroup {

    public MenuElements(Position position) {
        super(position);
    }

    @Override
    public ArrayList<GraphicElement> construct() {

        ArrayList<GraphicElement> el = new ArrayList<>();

        GraphicText gameTitle = new GraphicText(new Position(0, 0), getPosition())
                .setFontSize(20)
                .setText("Galaxy Intruders");

        final int textSize = 10;

        GraphicText startText = new GraphicText(new Position(0, 40), getPosition())
                .setFontSize(textSize)
                .setText("Start");

        GraphicText optionsText = new GraphicText(new Position(0, 60), getPosition())
                .setFontSize(textSize)
                .setText("Options");

        GraphicText exitText = new GraphicText(new Position(0, 80), getPosition())
                .setFontSize(textSize)
                .setText("Exit");

        el.add(gameTitle);
        el.add(startText);
        el.add(optionsText);
        el.add(exitText);

        return el;

    }


}
