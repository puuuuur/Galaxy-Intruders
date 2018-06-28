package com.hamiko.galaxyintruder.graphics.GUI;

import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.elements.GraphicElement;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;

import java.awt.*;

public class ScorePanel extends GraphicElement {

    private Font ps2p = new Font("Press Start 2P", Font.PLAIN, GameScale.xScale(6));
    private int score;

    public ScorePanel(Position position) {
        super(position);
    }

    @Override
    public void render(GameGraphics graphics) {

        graphics.getGraphics().setFont(ps2p);
        graphics.getGraphics().setColor(Color.WHITE);
        graphics.drawString("SCORE: " + score, this.getPosition().x, this.getPosition().y);

    }

    public void updateScore(int points) {
        this.score += Math.abs(points);
    }

    public int getScore() {
        return score;
    }
}
