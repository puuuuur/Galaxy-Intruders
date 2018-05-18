package com.hammiko.galaxyintruder.states;

import com.hammiko.galaxyintruder.graphics.MenuView;
import com.hammiko.galaxyintruder.statemachine.State;

public class MenuState extends GameState{

    public MenuState(){
        this.view = new MenuView();
    }
    @Override
    public State getStateName() {
        return State.MENU;
    }

    @Override
    public void update() {
       // System.out.println("Menu Stuff");
    }

    @Override
    public void render() {
        this.view.render();
        //System.out.println("Menu Stuff");
    }

}
