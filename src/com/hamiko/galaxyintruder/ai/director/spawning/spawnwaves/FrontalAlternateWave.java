package com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves;


import com.hamiko.galaxyintruder.physics.Position;

import java.util.HashMap;
import java.util.Map;

public class FrontalAlternateWave extends SpawnWaves {

    @Override
    protected Map<Position, Position> init() {

        Map<Position, Position> spawnPoints = new HashMap<>();

        spawnPoints.put(new Position(405, -100), new Position(405, 60));
        spawnPoints.put(new Position(335, -100), new Position(335, 60));
        spawnPoints.put(new Position(265, -100), new Position(265, 60));
        spawnPoints.put(new Position(195, -100), new Position(195, 60));
        spawnPoints.put(new Position(125, -100), new Position(125, 60));
        spawnPoints.put(new Position(55, -100), new Position(55, 60));

        return spawnPoints;

    }

}
