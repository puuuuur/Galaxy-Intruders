package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.graphics.ScaledGraphics;
import com.hamiko.galaxyintruder.physics.GameScale;

import java.awt.*;

public class MenuView extends GameView {

    private Font titleFont;
    ScaledGraphics gx = new ScaledGraphics();
    public MenuView() {
        titleFont = new Font("TimesRoman", Font.PLAIN, GameScale.xScale(16));
    }

    @Override
    public void render(Graphics g) {

        gx.setGraphics(g);

        gx.getGraphics().setFont(titleFont);
        gx.getGraphics().setColor(Color.WHITE);
        gx.drawString("Galaxy Intruders", 30, 30);

        gx.getGraphics().setFont(new Font("TimesRoman", Font.PLAIN, GameScale.xScale(12)));

    }
}
