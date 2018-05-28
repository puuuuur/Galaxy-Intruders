package com.hamiko.galaxyintruder.graphics.view;

import com.hamiko.galaxyintruder.window.Screen;

import java.awt.*;

public abstract class GameView extends Canvas {

    static Screen screen = Screen.getInstance();

    public abstract void render(Graphics g);

}
