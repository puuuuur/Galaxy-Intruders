package com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves;

import com.hamiko.galaxyintruder.physics.Position;

import java.util.HashMap;
import java.util.Map;

public class FrontalWave extends SpawnWaves {

    @Override
    protected Map<Position, Position> init() {

        Map<Position, Position> spawnPoints = new HashMap<>();

        spawnPoints.put(new Position(440, -100), new Position(440, 30));
        spawnPoints.put(new Position(370, -100), new Position(370, 30));
        spawnPoints.put(new Position(300, -100), new Position(300, 30));
        spawnPoints.put(new Position(230, -100), new Position(230, 30));
        spawnPoints.put(new Position(160, -100), new Position(160, 30));
        spawnPoints.put(new Position(90, -100), new Position(90, 30));
        spawnPoints.put(new Position(20, -100), new Position(20, 30));

        return spawnPoints;

    }

}
