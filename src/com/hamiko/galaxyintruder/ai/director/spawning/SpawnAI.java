package com.hamiko.galaxyintruder.ai.director.spawning;

import com.hamiko.galaxyintruder.ai.Behavior;
import com.hamiko.galaxyintruder.ai.director.spawning.spawnwaves.SpawnWaves;
import com.hamiko.galaxyintruder.entities.SpaceShip;
import com.hamiko.galaxyintruder.physics.Position;

import java.util.Map;

public class SpawnAI implements Behavior {

    private SpawnWaves spawnPoints;
    private Map.Entry<Position, Position> entry;

    public SpawnAI(SpawnWaves points, Map.Entry<Position, Position> entry){
        this.spawnPoints = points;
        this.entry = entry;
    }

    @Override
    public void act(SpaceShip ship) {

        int speed = spawnPoints.getSpeed();
        int deltaX = ship.getPosition().x - entry.getValue().x;
        int deltaY = ship.getPosition().y - entry.getValue().y;

        if (deltaX != 0) {

            if (ship.getPosition().x < entry.getValue().x && entry.getValue().x - speed <= ship.getPosition().x) {
                ship.getPosition().x = entry.getValue().x;
            } else {
                if (deltaX > 0) speed *= -1;
                ship.getPosition().x += speed;
            }

        }

        if (deltaY != 0) {

            if (ship.getPosition().y < entry.getValue().y && entry.getValue().y - speed <= ship.getPosition().y) {
                ship.getPosition().y = entry.getValue().y;
            } else {
                if (deltaY > 0) speed *= -1;
                ship.getPosition().y += speed;
            }

        }

    }

}
