package com.hamiko.galaxyintruder.input;

import java.awt.event.KeyEvent;

public class MenuInput extends InputHandler {

    public MenuInput() {

        keyMap.put(KeyEvent.VK_W, false);
        keyMap.put(KeyEvent.VK_S, false);
        keyMap.put(KeyEvent.VK_C, false);
        keyMap.put(KeyEvent.VK_SPACE, false);
        keyMap.put(KeyEvent.VK_ENTER, false);
        keyMap.put(KeyEvent.VK_ESCAPE, false);

    }

    boolean upPressed = false;


    public boolean up() {
        return keyMap.get(KeyEvent.VK_W);
    }


    boolean downPressed = false;

    //TODO register only one press and ignore until key up
    public boolean down() {
        return keyMap.get(KeyEvent.VK_S);
    }

    public boolean confirm() {
        return keyMap.get(KeyEvent.VK_SPACE) || keyMap.get(KeyEvent.VK_ENTER);
    }

    public boolean cancel() {
        return keyMap.get(KeyEvent.VK_C) || keyMap.get(KeyEvent.VK_ESCAPE);
    }

}
