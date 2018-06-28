package com.hamiko.galaxyintruder.sound;

import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BackgroundSound {

    private final String BG_URI = "res/sounds/music/theme.mp3";

    public BackgroundSound() {
        //TODO fix bug where music does not start or it fades away
        //TODO implement sound looping
        try {
            Thread.sleep(1000);
            Platform.startup(this::play);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void play(){

        Media hit = new Media(new File(BG_URI).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

    }

}
