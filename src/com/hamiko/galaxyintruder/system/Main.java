package com.hamiko.galaxyintruder.system;

import com.hamiko.galaxyintruder.game.Game;
import com.hamiko.galaxyintruder.resource.ResourceHandler;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.graphics.window.Screen;


public class Main {

    public static void main(String[] args) {

        ResourceHandler.preload();

        Game game = new Game(
                Screen.getInstance(),
                GameStateMachine.getInstance()
        );

        Thread gameThread = new Thread(game, "GAME_THREAD");
        game.setGameThread(gameThread);
        gameThread.start();

    }

}
