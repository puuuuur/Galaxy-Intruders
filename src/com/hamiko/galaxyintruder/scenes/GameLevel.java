package com.hamiko.galaxyintruder.scenes;

import com.hamiko.galaxyintruder.ai.director.Director;
import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.effect.Effect;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.graphics.GUI.ScorePanel;
import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.background.BackGroundHandler;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.Routine;
import com.hamiko.galaxyintruder.statemachine.State;
import com.hamiko.galaxyintruder.statemachine.states.GameOverState;

public class GameLevel implements Drawable {

    private int difficultyScale = 1;

    private EntityPool<Enemy> enemyPool;
    private EntityPool<Projectile> projectilesPool;
    private EntityPool<Effect> effectsPool;

    private Player player;
    private Director director;

    private BackGroundHandler background;
    private ScorePanel scorePanel;

    public GameLevel() {

        enemyPool = new EntityPool<>();
        projectilesPool = new EntityPool<>();
        effectsPool = new EntityPool<>();
        background = new BackGroundHandler();
        scorePanel = new ScorePanel(new Position(1, 3));
        director = new Director(this, enemyPool);

    }

    public void update() {

        director.update();
        background.update();
        player.update();
        enemyPool.update();
        projectilesPool.update();
        effectsPool.update();

    }

    @Override
    public void render(GameGraphics gx) {

        background.render(gx);
        scorePanel.render(gx);

        gx.drawSpaceShip(player);

        for (SpaceShip e : enemyPool) {
            gx.drawSpaceShip(e);
        }

        for (Projectile p : projectilesPool) {
            gx.drawProjectile(p);
        }

        for (Effect p : effectsPool) {
            gx.drawEntity(p);
        }

    }

    public EntityPool<Enemy> getEnemyPool() {
        return enemyPool;
    }

    public EntityPool<Effect> getEffectsPool() {
        return effectsPool;
    }

    public EntityPool<Projectile> getProjectilesPool() {
        return projectilesPool;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void updateScore(int score) {
        this.scorePanel.updateScore(score);
    }

    public void raiseDifficulty() {
        difficultyScale++;
    }

    public int getDifficultyScale() {
        return difficultyScale;
    }

    public void triggerGameOver() {

        GameStateMachine.getInstance().getState(State.GAME_PLAY).addRoutine(new Routine() {

            int timer;

            @Override
            public void perform() {

                player.getGraphics().setCurrentSprite(null);

                if (timer++ / 60 >= 1) {

                    ((GameOverState) GameStateMachine.getInstance().getState(State.GAME_OVER))
                            .setScore(scorePanel.getScore());
                    GameStateMachine.getInstance().setActiveState(State.GAME_OVER);

                }

            }

        });

    }

}
