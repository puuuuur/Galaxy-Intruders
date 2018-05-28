package com.hamiko.galaxyintruder.game;

import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.window.Screen;

public class Game implements Runnable {

    private boolean isRunning = false;
    private String gameTitle = "Galaxy Intruders";

    private GameStateMachine gsm;

    private Screen screen;
    private Thread gameThread;

    public Game(Screen screen, GameStateMachine gsm) {
        this.screen = screen;
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

        screen.setOnCloseEvent(this::stopGame);
        screen.setGameView(gsm.getActiveState().getView());
        gsm.getActiveState().getView().addKeyListener(gsm.getActiveState().getInput());
        gsm.getActiveState().getView().requestFocus();

        new Thread(screen, "SCREEN_THREAD").start();

        while (isRunning) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {

                update();
                delta--;
                updates++;
                frames++;

            }

            if (System.currentTimeMillis() - timer > 1000) {

                screen.setTitle(gameTitle + "  |   " + updates + " ups, " + frames + " fps");
                timer += 1000;
                updates = 0;
                frames = 0;

            }

        }

    }

    private void update() {
        gsm.update();
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
