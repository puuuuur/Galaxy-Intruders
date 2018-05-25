package com.hamiko.galaxyintruder.level;

import com.hamiko.galaxyintruder.entities.Entity;
import com.hamiko.galaxyintruder.entities.player.Player;

import java.util.ArrayList;

public class GameLevel {

    //TODO consider seperating pool for enemies, effects, projectiles
    private ArrayList<Entity> enemyPool = new ArrayList<>();
    private Player player;


    public void update() {

        player.update();

        for (Entity e : enemyPool) {
            e.update();
        }

    }

    public ArrayList<Entity> getEnemyPool() {
        return enemyPool;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
