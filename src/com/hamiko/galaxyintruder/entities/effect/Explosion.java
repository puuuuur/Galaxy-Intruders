package com.hamiko.galaxyintruder.entities.effect;

import com.hamiko.galaxyintruder.graphics.manager.GraphicsManager;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.GameLevel;
import com.hamiko.galaxyintruder.sound.SoundManager;

import java.util.Random;

public class Explosion extends Effect {

    private GraphicsManager graphics;

    public Explosion(GameLevel level, Position position) {
        this(level, position, "res/entities/effects/explosion.png");
    }

    public Explosion(GameLevel level, Position position, String explosionUri) {

        super(level);
        graphics = new ExplosionGraphics(explosionUri);
        getPosition().setLocation(position);
        SoundManager sound = new SoundManager();

        String uri = "res/sounds/explosion/explosion_two.wav";
        //50% to se other explosion sound
        if(new Random().nextInt(2) == 0){
            uri = "res/sounds/explosion/explosion_one.wav";
        }

        sound.loadSoundEffects("exp", uri);
        sound.playSound("exp");

    }

    @Override
    public GraphicsManager getGraphics() {
        return graphics;
    }

    @Override
    public void update() {

        graphics.getAnimations().update();

        if(graphics.getAnimations().isDone()){
            this.level.getEffectsPool().kill(this);
        }

    }

}
