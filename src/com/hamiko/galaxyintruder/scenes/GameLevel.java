package com.hamiko.galaxyintruder.scenes;

import com.hamiko.galaxyintruder.ai.director.Director;
import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.graphics.GUI.ScorePanel;
import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.background.BackGroundHandler;
import com.hamiko.galaxyintruder.physics.Position;

public class GameLevel implements Drawable {

    private EntityPool<Enemy> enemyPool;
    private EntityPool<Projectile> projectilesPool;

    private Player player;
    private Director director;

    private BackGroundHandler background;
    private ScorePanel scorePanel;

    public GameLevel(){
        enemyPool = new EntityPool<>();
        projectilesPool = new EntityPool<>();
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

    }

    public EntityPool<Enemy> getEnemyPool() {
        return enemyPool;
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

    public ScorePanel getScorePanel(){
        return this.scorePanel;
    }

}
