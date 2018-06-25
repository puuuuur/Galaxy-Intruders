package com.hamiko.galaxyintruder.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BackgroundSound {

    private final String BG_URI = "res/sounds/music/theme.mp3";

    public void run(){

        Media hit = new Media(new File(BG_URI).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

    }

}
