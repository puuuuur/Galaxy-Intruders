package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.graphics.ScaledGraphics;

import java.awt.*;

public class MenuView extends GameView {

    private Font titleFont;

    public MenuView() {
        titleFont = new Font("TimesRoman", Font.PLAIN, (int)(100 * screen.xScale()));
    }

    @Override
    public void paintComponent(Graphics gx) {

        ScaledGraphics g = new ScaledGraphics(gx);

        g.getGraphics().setFont(titleFont);
        g.getGraphics().setColor(Color.WHITE);
        g.drawString("Galaxy Intruders", 200, 150);

        g.getGraphics().setFont(new Font("TimesRoman", Font.PLAIN, (int)(12 * screen.xScale())));

    }

}
