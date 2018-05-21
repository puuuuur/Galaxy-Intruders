package com.hammiko.galaxyintruder.graphics.view;

import com.hammiko.galaxyintruder.window.Screen;

import javax.swing.*;

public abstract class GameView extends JPanel {

    protected static Screen screen = Screen.getInstance();

    public abstract void update();

}
