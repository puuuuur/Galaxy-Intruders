package com.hamiko.galaxyintruder.ai.director;

import com.hamiko.galaxyintruder.ai.director.spawning.EnemySpawner;
import com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves.FlankingWave;
import com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves.FrontalAlternateWave;
import com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves.FrontalWave;
import com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves.SpawnWaves;
import com.hamiko.galaxyintruder.entities.EntityPool;
import com.hamiko.galaxyintruder.entities.enemies.Enemy;
import com.hamiko.galaxyintruder.scenes.GameLevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Handles level directing (Spawning enemies ect.)
 */
public class Director {

    enum Wave {
        FRONTAL, FLANK, FRONTAL_ALTERNATE
    }

    private Wave nextWave = Wave.FLANK;

    private EnemySpawner enemySpawner;
    private GameLevel gameLevel;
    private EntityPool<Enemy> enemyPool;
    private Map<Wave, SpawnWaves> spawningMap;

    private int timer;
    private int difficultyCounter;
    private boolean spawnAlternate = false;//flag to prevent spawning extra wave if already spawned

    public Director(GameLevel gameLevel, EntityPool<Enemy> pool) {

        this.enemyPool = pool;
        this.gameLevel = gameLevel;
        this.enemySpawner = new EnemySpawner(enemyPool, gameLevel);

        spawningMap = new HashMap<>();
        spawningMap.put(Wave.FRONTAL, new FrontalWave());
        spawningMap.put(Wave.FLANK, new FlankingWave());
        spawningMap.put(Wave.FRONTAL_ALTERNATE, new FrontalAlternateWave());

        enemySpawner.spawn(spawningMap.get(Wave.FRONTAL));

    }

    public void update() {

        if (spawnAlternate) {

            timer++;

            if (timer / 60 >= 10) {
                enemySpawner.spawn(spawningMap.get(Wave.FRONTAL_ALTERNATE));
                timer = 0;
                spawnAlternate = false;
            }

        }

        if (enemyPool.isEmpty()) {

            if (difficultyCounter++ >= 5) {
                difficultyCounter = 0;
                gameLevel.raiseDifficulty();
            }

            enemySpawner.spawn(spawningMap.get(nextWave));
            //30% chance to spawn extra wave
            if (new Random().nextInt(3) == 0 && !spawnAlternate) {
                spawnAlternate = true;
            }

            nextWave = (nextWave == Wave.FRONTAL) ? Wave.FLANK : Wave.FRONTAL;

        }

    }

}
