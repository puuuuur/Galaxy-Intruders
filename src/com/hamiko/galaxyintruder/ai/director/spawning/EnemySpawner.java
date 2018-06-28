package com.hamiko.galaxyintruder.ai.director.spawning;

import com.hamiko.galaxyintruder.ai.Behavior;
import com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves.SpawnWaves;
import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.entities.enemies.small.BasicSmallShip;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;

public class EnemySpawner {

    private EntityPool<Enemy> enemyPool;
    private GameLevel level;

    public EnemySpawner(EntityPool<Enemy> enemyPool, GameLevel level) {
        this.enemyPool = enemyPool;
        this.level = level;
    }

    public void spawn(SpawnWaves spawnPoints) {

        spawnPoints.getSpawnPoints().entrySet().forEach(i -> {

            Position pos = new Position();
            pos.setLocation(i.getKey());
            BasicSmallShip ship = new BasicSmallShip(level, pos);

            Behavior behavior = new SpawnAI(spawnPoints, i);
            ship.getBehavior().addAct(behavior);
            enemyPool.add(ship);

        });

    }

}
