package com.hamiko.galaxyintruder.level;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.player.Player;

import java.util.ArrayList;

public class GameLevel {

    //TODO consider seperating pool for enemies, effects, projectiles
    private ArrayList<Entity> enemyPool = new ArrayList<>();

    private ArrayList<Entity> projectilesPool = new ArrayList<>();

    private Player player;


    public void update() {

        player.update();

        for (Entity e : enemyPool) {
            e.update();
        }

        for (Entity e : projectilesPool) {
            e.update();
        }

    }

    public ArrayList<Entity> getEnemyPool() {
        return enemyPool;
    }

    public ArrayList<Entity> getProjectilesPool() {
        return projectilesPool;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addProjectile(Entity entity){
        projectilesPool.add(entity);
    }
}
