package com.hammiko.galaxyintruder.game;

import com.hammiko.galaxyintruder.statemachine.GameStateMachine;
import com.hammiko.galaxyintruder.window.GameFrame;

public class Game implements Runnable {

    private boolean isRunning = false;
    private String gameTitle = "Galaxy Intruders";

    private GameStateMachine gsm;

    private GameFrame gameFrame;
    private Thread gameThread;

    public Game(GameFrame frame, GameStateMachine gsm) {
        this.gameFrame = frame;
        this.gsm = gsm;
    }

    @Override
    public void run() {

        isRunning = true;

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;

        gameFrame.requestFocus();
        gameFrame.setOnCloseEvent(this::stopGame);
        gameFrame.setActiveView(gsm.getActiveState().getView());

        while (isRunning) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {

                update();
                delta--;
                updates++;
                render();
                frames++;

            }

            if (System.currentTimeMillis() - timer > 1000) {

                timer += 1000;
                gameFrame.setTitle(gameTitle + "  |   " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;

            }

        }


    }

    private void update() {
        gsm.getActiveState().update();
    }

    private void render() {
        gsm.getActiveState().render();
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    private void stopGame() {
        setIsRunning(false);
        this.gameThread.interrupt();
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

}
