package com.hamiko.galaxyintruder.graphics.GUI;

import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.elements.GraphicElement;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;

import java.awt.*;

public class GraphicText extends GraphicElement {

    private Font font;
    private String text;
    private Color color = Color.WHITE;

    public GraphicText(Position position, Position relativePosition) {
        super(position, relativePosition);
    }

    public GraphicText(Position position) {
        super(position);
    }

    public GraphicText setFontSize(int fontSize) {
        this.font = new Font("Press Start 2P", Font.PLAIN, GameScale.xScale(fontSize));
        return this;
    }

    public GraphicText setText(String text){
        this.text = text;
        return this;
    }

    public GraphicText setColor(Color color) {
        this.color = color;
        return this;
    }

    @Override
    public void render(GameGraphics graphics) {

        graphics.getGraphics().setFont(font);
        graphics.getGraphics().setColor(color);
        graphics.getGraphics().drawString(text, getPosition().x, getPosition().y);

    }

}
