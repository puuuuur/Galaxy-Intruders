package com.hamiko.galaxyintruder.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SoundManager {

    ExecutorService soundPool = Executors.newFixedThreadPool(20);
    Map<String, SourceDataLine> soundInfoMap = new HashMap<>();
    Map<String, AudioInputStream> soundEffectsMap = new HashMap<>();

    private static final int BUFFER_SIZE = 4096;

    public void loadSoundEffects(String id,String url) {
        File audioFile = new File(url);
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);

            audioLine.open(format);
            soundInfoMap.put(id, audioLine);
            soundEffectsMap.put(id, audioStream);

        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
                System.out.println("Error playing the audio file.");
                ex.printStackTrace();
            }
    }

    public void playSound(final String id) {
        Runnable soundPlay = new Runnable() {
            @Override
            public void run() {
                try {
                    soundInfoMap.get(id).start();
                    byte[] bytesBuffer = new byte[BUFFER_SIZE];
                    int bytesRead = -1;

                    while ((bytesRead = soundEffectsMap.get(id).read(bytesBuffer)) != -1) {
                        soundInfoMap.get(id).write(bytesBuffer, 0, bytesRead);
                    }

                }catch (IOException ex) {
                    System.out.println("Error playing the audio file.");
                    ex.printStackTrace();
                }
            }
        };
        soundPool.execute(soundPlay);
    }

    public void getMap (String id) {
        System.out.println(soundInfoMap.get(id));
    }

}
