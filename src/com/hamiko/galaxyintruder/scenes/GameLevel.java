package com.hamiko.galaxyintruder.scenes;

import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;
import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.background.BackGroundHandler;

public class GameLevel implements Drawable {

    private EntityPool<Enemy> enemyPool = new EntityPool<>();
    private EntityPool<Projectile> projectilesPool = new EntityPool<>();

    private Player player;
    private BackGroundHandler background = new BackGroundHandler();

    public void update() {

        background.update();

        player.update();
        enemyPool.update();
        projectilesPool.update();

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

    @Override
    public void render(GameGraphics gx) {

        background.render(gx);

        gx.drawSpaceShip(player);

        for (SpaceShip e : enemyPool) {
            gx.drawSpaceShip(e);
        }

        for (Projectile p : projectilesPool) {
            gx.drawProjectile(p);
        }

    }

}
