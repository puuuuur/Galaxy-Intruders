package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.graphics.ScaledGraphics;
import com.hamiko.galaxyintruder.physics.GameScale;

import java.awt.*;

public class MenuView extends GameView {

    private Font titleFont;

    public MenuView() {
        titleFont = new Font("TimesRoman", Font.PLAIN, (int) (100 * GameScale.xScale()));
    }

    @Override
    public void render(Graphics g) {

        ScaledGraphics gx = new ScaledGraphics(g);

        gx.getGraphics().setFont(titleFont);
        gx.getGraphics().setColor(Color.WHITE);
        gx.drawString("Galaxy Intruders", 200, 150);

        gx.getGraphics().setFont(new Font("TimesRoman", Font.PLAIN, (int) (12 * GameScale.xScale())));

    }
}
