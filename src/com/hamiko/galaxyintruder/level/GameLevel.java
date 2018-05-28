package com.hamiko.galaxyintruder.level;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.player.Player;

public class GameLevel {

    private EntityPool<Entity> enemyPool = new EntityPool<>();
    private EntityPool<Entity> projectilesPool = new EntityPool<>();

    private Player player;

    public void update() {

        player.update();
        enemyPool.update();
        projectilesPool.update();

    }

    public EntityPool<Entity> getEnemyPool() {
        return enemyPool;
    }

    public EntityPool<Entity> getProjectilesPool() {
        return projectilesPool;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
