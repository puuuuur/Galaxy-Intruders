package com.hamiko.galaxyintruder.statemachine.states;

import com.hamiko.galaxyintruder.graphics.GUI.MenuControls;
import com.hamiko.galaxyintruder.graphics.GUI.MenuCursor;
import com.hamiko.galaxyintruder.graphics.elements.menu.PauseElements;
import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.input.MenuInput;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.scenes.PauseMenu;

public class PauseState extends GameState {

    PauseMenu pauseMenu;

    public PauseState(GameView view, MenuInput input) {
        super(view, input);

        Position labelPos = new Position(200, 80);
        PauseElements pauseElements = new PauseElements(labelPos );
        MenuCursor cursor = new MenuCursor(new Position(-14, 30), pauseElements.getPosition());
        MenuControls controls = new MenuControls(input);

        pauseMenu = new PauseMenu(controls, cursor);
        view.addElements(pauseElements, cursor);

    }

    @Override
    public void update() {
        this.pauseMenu.update();
    }

}
