package com.hamiko.galaxyintruder.game;

import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;
import com.hamiko.galaxyintruder.graphics.window.Screen;
import com.hamiko.galaxyintruder.system.PerformanceTracker;

public class Game implements Runnable {

    private boolean isRunning = false;

    private GameStateMachine gsm;

    private Screen screen;
    private Thread gameThread;

    public Game(Screen screen, GameStateMachine gsm) {
        this.screen = screen;
        this.gsm = gsm;
    }

    @Override
    public void run() {
        gameLoop();
    }

    private void gameLoop() {

        isRunning = true;

        gsm.setActiveState(State.MENU);
        screen.setOnCloseEvent(this::stopGame);

        final int TICKS_PER_SECOND = 60;
        final long SKIP_TICKS = 1000000000 / TICKS_PER_SECOND;
        final int MAX_FRAMESKIP = 5;

        long next_game_tick = System.nanoTime();
        long timer = System.currentTimeMillis();
        int loops;

        int fps = 0;

        int updates = 0;

        while (isRunning) {

            loops = 0;
            while (System.nanoTime() > next_game_tick && loops < MAX_FRAMESKIP) {
                update();
                next_game_tick += SKIP_TICKS;
                loops++;
                updates++;
            }

            GameScale.setFrameInterpolation(
                    (float) (System.nanoTime() + SKIP_TICKS - next_game_tick) / (float) (SKIP_TICKS));

            screen.render();
            fps++;

            if (System.currentTimeMillis() - timer > 1000) {

                PerformanceTracker.updateValues(updates, fps);

                timer += 1000;
                updates = 0;
                fps = 0;

            }

        }

    }

    private void update() {
        gsm.update();
    }

    //TODO Not needed if not using a second thread
    private void stopGame() {
        this.isRunning = false;
        this.gameThread.interrupt();
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

}
