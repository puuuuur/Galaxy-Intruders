package com.hamiko.galaxyintruder;

import com.hamiko.galaxyintruder.game.Game;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.window.Screen;

public class Main {

    public static void main(String[] args) {

        Screen screen = Screen.getInstance();

        Game game = new Game(
                screen,
                GameStateMachine.getInstance()
        );

        Thread gameThread = new Thread(game, "GAME_THREAD");
        Thread screenThread = new Thread(screen, "SCREEN_THREAD");
        game.setGameThread(gameThread);

        screenThread.start();
        gameThread.start();

    }

}
