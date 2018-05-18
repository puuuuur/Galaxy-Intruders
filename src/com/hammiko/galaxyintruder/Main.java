package com.hammiko.galaxyintruder;

import com.hammiko.galaxyintruder.game.Game;
import com.hammiko.galaxyintruder.statemachine.GameStateMachine;
import com.hammiko.galaxyintruder.window.GameFrame;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(
                new GameFrame(),
                GameStateMachine.getInstance()
        );

        Thread gameThread = new Thread(game, "GAME_THREAD");
        game.setGameThread(gameThread);
        gameThread.start();

    }

}
