package com.hamiko.galaxyintruder.level;

import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.entities.projectiles.Projectile;

public class GameLevel {

    private EntityPool<Enemy> enemyPool = new EntityPool<>();
    private EntityPool<Projectile> projectilesPool = new EntityPool<>();

    private Player player;

    public void update() {

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

}
