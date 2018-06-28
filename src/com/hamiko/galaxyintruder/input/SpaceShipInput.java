package com.hamiko.galaxyintruder.input;

import java.awt.event.KeyEvent;

public class SpaceShipInput extends InputHandler {

    public SpaceShipInput() {

        keyMap.put(KeyEvent.VK_W, false);
        keyMap.put(KeyEvent.VK_S, false);
        keyMap.put(KeyEvent.VK_A, false);
        keyMap.put(KeyEvent.VK_D, false);
        keyMap.put(KeyEvent.VK_UP, false);
        keyMap.put(KeyEvent.VK_DOWN, false);
        keyMap.put(KeyEvent.VK_LEFT, false);
        keyMap.put(KeyEvent.VK_RIGHT, false);
        keyMap.put(KeyEvent.VK_F, false);
        keyMap.put(KeyEvent.VK_SHIFT, false);
        keyMap.put(KeyEvent.VK_SPACE, false);
        keyMap.put(KeyEvent.VK_ESCAPE, false);

    }

    public boolean up() {
        return keyMap.get(KeyEvent.VK_W) || keyMap.get(KeyEvent.VK_UP);
    }

    public boolean down() {
        return keyMap.get(KeyEvent.VK_S) || keyMap.get(KeyEvent.VK_DOWN);
    }

    public boolean left() {
        return keyMap.get(KeyEvent.VK_A) || keyMap.get(KeyEvent.VK_LEFT);
    }

    public boolean right() {
        return keyMap.get(KeyEvent.VK_D) || keyMap.get(KeyEvent.VK_RIGHT);
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
