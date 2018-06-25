package com.hamiko.galaxyintruder.ai.director;

import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.enemies.small.BasicSmallShip;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;

/**
 * Object handles level directing (Spawning enemies ect.)
 */
public class Director {

    private GameLevel gameLevel;
    private EntityPool<Enemy> enemyPool;
    private int originalSize;

    public Director(GameLevel gameLevel, EntityPool<Enemy> pool) {

        this.gameLevel = gameLevel;
        this.enemyPool = pool;

        enemyPool.add(new BasicSmallShip(gameLevel, new Position(240, 30)));
        enemyPool.add(new BasicSmallShip(gameLevel, new Position(170, 30)));
        enemyPool.add(new BasicSmallShip(gameLevel, new Position(100, 30)));
        enemyPool.add(new BasicSmallShip(gameLevel, new Position(30, 30)));

        originalSize = enemyPool.size();
    }

    public void update(){

        if(enemyPool.size() != originalSize){
            enemyPool.add(new BasicSmallShip(gameLevel, new Position(360, 30)));
        }

    }

}
