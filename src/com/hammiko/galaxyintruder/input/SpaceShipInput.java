package com.hammiko.galaxyintruder.input;

import java.awt.event.KeyEvent;

public class SpaceShipInput extends InputHandler {

    public SpaceShipInput() {

        keyMap.put(KeyEvent.VK_W, false);
        keyMap.put(KeyEvent.VK_S, false);
        keyMap.put(KeyEvent.VK_A, false);
        keyMap.put(KeyEvent.VK_D, false);
        keyMap.put(KeyEvent.VK_F, false);
        keyMap.put(KeyEvent.VK_SHIFT, false);
        keyMap.put(KeyEvent.VK_SPACE, false);
        keyMap.put(KeyEvent.VK_ESCAPE, false);

    }

    public boolean up() {
        return keyMap.get(KeyEvent.VK_W);
    }

    public boolean down() {
        return keyMap.get(KeyEvent.VK_S);
    }

    public boolean left() {
        return keyMap.get(KeyEvent.VK_A);
    }

    public boolean right() {
        return keyMap.get(KeyEvent.VK_D);
    }

    public boolean fire() {
        return keyMap.get(KeyEvent.VK_SPACE);
    }

    public boolean altFire() {
        return keyMap.get(KeyEvent.VK_F);
    }

    public boolean speedBoost() {
        return keyMap.get(KeyEvent.VK_SHIFT);
    }

    public boolean pause() {
        return keyMap.get(KeyEvent.VK_ESCAPE);
    }

}
