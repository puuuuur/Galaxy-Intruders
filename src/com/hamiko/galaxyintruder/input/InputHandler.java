package com.hamiko.galaxyintruder.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class InputHandler implements KeyListener {

    Map<Integer, Boolean> keyMap = new HashMap<>();

    @Override
    public void keyPressed(KeyEvent e) {

        if(keyMap.containsKey(e.getKeyCode())){
            keyMap.replace(e.getKeyCode(), true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(keyMap.containsKey(e.getKeyCode()) && keyMap.get(e.getKeyCode())){
            keyMap.replace(e.getKeyCode(), false);
        }

    }

    //Returns only pressed keys
    public Map<Integer, Boolean> getPressedKeys(){

        return keyMap.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    public Map<Integer, Boolean> getKeyMap(){
        return keyMap;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
