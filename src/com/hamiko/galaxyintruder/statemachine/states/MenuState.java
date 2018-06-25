package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.GUI.MenuControls;
import com.hamiko.galaxyintruder.graphics.GUI.MenuCursor;
import com.hamiko.galaxyintruder.graphics.elements.menu.MenuElements;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.MainMenu;

public class MenuState extends GameState {

    private MainMenu mainMenu;

    public MenuState(GameView view, MenuInput input) {
        super(view, input);

//        MenuElements menuText = new OptionsElement(new Position(100, 100));
        MenuElements menuText = new MenuElements(new Position(100, 100));
        MenuCursor cursor = new MenuCursor(new Position(-14, 30), menuText.getPosition());
        MenuControls controls = new MenuControls(input);

        mainMenu = new MainMenu(controls, cursor);
        view.addElements(menuText, cursor);


    }

    @Override
    public void update() {
        mainMenu.update();
    }


}
