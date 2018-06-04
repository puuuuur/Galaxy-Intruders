package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.GUI.MenuArrow;
import com.hamiko.galaxyintruder.graphics.elements.menu.MenuElements;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class MenuState extends GameState {

    MenuArrow menuArrow;

    public MenuState(GameView view, MenuInput input) {
        super(view, input);

        MenuElements menuText = new MenuElements(new Position(100, 100));
        menuArrow = new MenuArrow(new Position(-14, 30), menuText.getPosition());

        view.addElements(menuText, menuArrow);

    }

    @Override
    public void update() {

        MenuInput controls = (MenuInput) this.input;
        if (controls.cancel()) {
            GameStateMachine.getInstance().setActiveState(State.GAME_PLAY);
        } else if (controls.up()) {
            menuArrow.getPosition().move(menuArrow.getPosition().x, menuArrow.getPosition().y - 20);

        } else if (controls.down()) {
            menuArrow.getPosition().move(menuArrow.getPosition().x, menuArrow.getPosition().y + 40);
        }

    }

}
