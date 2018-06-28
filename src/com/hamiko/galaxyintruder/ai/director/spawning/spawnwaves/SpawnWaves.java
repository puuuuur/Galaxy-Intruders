package com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves;

import com.hamiko.galaxyintruder.physics.Position;
import java.util.Map;

public abstract class SpawnWaves {

    private Map<Position, Position> spawnPoints;

    public SpawnWaves() {
        this.spawnPoints = this.init();
    }

    public Map<Position, Position> getSpawnPoints(){
        return this.spawnPoints;
    }

    protected abstract Map<Position, Position> init();

    public int getSpeed(){
        return 1;
    }

}
