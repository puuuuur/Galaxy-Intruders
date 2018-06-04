package com.hamiko.galaxyintruder;

import com.hamiko.galaxyintruder.game.Game;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.graphics.window.Screen;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        loadResources();

        Game game = new Game(
                Screen.getInstance(),
                GameStateMachine.getInstance()
        );

        Thread gameThread = new Thread(game, "GAME_THREAD");
        game.setGameThread(gameThread);
        gameThread.start();

    }

    private static void loadResources() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/PressStart2P.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

}
