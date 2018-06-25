package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.graphics.GameGraphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameView {

    private ArrayList<Drawable> elements = new ArrayList<>();
    private GameGraphics gx = new GameGraphics();

    public void render(Graphics g) {

        gx.setGraphics(g);

        for (Drawable el : elements) {
            el.render(gx);
        }

    }

    public void addElements(Drawable... elements) {
        this.elements.addAll(Arrays.asList(elements));
    }

}
