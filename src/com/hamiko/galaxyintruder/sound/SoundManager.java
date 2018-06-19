package com.hamiko.galaxyintruder.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SoundManager {


    ExecutorService soundPool = Executors.newFixedThreadPool(2);
    Map<String, Media> soundMap = new HashMap<>();
    Map<String, AudioInputStream> soundEffectsMap = new HashMap<>();

    public void loadSoundEffects(String id,String url) {
        Media sound = new Media(new File(url).toURI().toString());
        soundMap.put(id, sound);

    }

    public void playSound(final String id) {
        Runnable soundPlay = new Runnable() {
            @Override
            public void run() {
                    MediaPlayer mediaPlayer = new MediaPlayer(soundMap.get(id));
                    mediaPlayer.play();
            }
        };
        soundPool.execute(soundPlay);
    }

    public void getMap (String id) {
        System.out.println(soundMap.get(id));

    }


}
