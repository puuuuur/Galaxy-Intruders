package com.hamiko.galaxyintruder.graphics.elements.menu;

import com.hamiko.galaxyintruder.graphics.GUI.GraphicText;
import com.hamiko.galaxyintruder.graphics.elements.GraphicElement;
import com.hamiko.galaxyintruder.graphics.elements.GraphicsGroup;
import com.hamiko.galaxyintruder.physics.Position;

import java.util.ArrayList;

public class GameOverElements extends GraphicsGroup {

    private ArrayList<GraphicElement> elements;
    public GameOverElements(Position position) {
        super(position);
    }

    @Override
    public ArrayList<GraphicElement> construct() {

        elements = new ArrayList<>();

        GraphicText gameOverTitle = new GraphicText(new Position(0, 0), getPosition())
                .setFontSize(20)
                .setText("GAME OVER");

        GraphicText scoreText = new GraphicText(new Position(0, 40), getPosition()).setFontSize(10);

        GraphicText toMenuText1 = new GraphicText(new Position(0, 100), getPosition())
                .setFontSize(10)
                .setText("Press Confirm to");
        GraphicText toMenuText2 = new GraphicText(new Position(0, 120), getPosition())
                .setFontSize(10)
                .setText("return to the Menu.");

        elements.add(gameOverTitle);
        elements.add(scoreText);
        elements.add(toMenuText1);
        elements.add(toMenuText2);

        return elements;

    }

    public void setScore(int score) {
        ((GraphicText) elements.get(1)).setText("Final Score: " + score);
    }

}
