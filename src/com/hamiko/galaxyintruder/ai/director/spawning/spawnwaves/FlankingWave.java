package com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves;

import com.hamiko.galaxyintruder.graphics.window.Screen;
import com.hamiko.galaxyintruder.physics.Position;

import java.util.HashMap;
import java.util.Map;

public class FlankingWave extends SpawnWaves {

    @Override
    protected Map<Position, Position> init() {

        Map<Position, Position> spawnPoints = new HashMap<>();
        int screenWidth = Screen.getInstance().getTrueWidth();

        spawnPoints.put(new Position(-30, 30), new Position(200, 30));
        spawnPoints.put(new Position(screenWidth + 30, 30), new Position(260, 30));

        spawnPoints.put(new Position(-60, 60), new Position(160, 60));
        spawnPoints.put(new Position(screenWidth + 60, 60), new Position(300, 60));

        spawnPoints.put(new Position(-90, 90), new Position(120, 90));
        spawnPoints.put(new Position(screenWidth + 90, 90), new Position(340, 90));

        spawnPoints.put(new Position(-120, 120), new Position(80, 120));
        spawnPoints.put(new Position(screenWidth + 120, 120), new Position(380, 120));

        return spawnPoints;

    }

    @Override
    public int getSpeed() {
        return 4;
    }
}
