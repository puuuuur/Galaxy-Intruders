package com.hamiko.galaxyintruder.scenes;

import com.hamiko.galaxyintruder.graphics.GUI.MenuControls;
import com.hamiko.galaxyintruder.graphics.GUI.MenuCursor;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class MainMenu {

    private MenuControls controls;
    private MenuCursor cursor;

    private enum CursorPosition {START, OPTION, EXIT}

    private CursorPosition currentCursorPosition = CursorPosition.START;
    private Position originalCursorPosition;

    public MainMenu(MenuControls controls, MenuCursor cursor) {

        this.controls = controls;
        this.cursor = cursor;
        this.originalCursorPosition = new Position(cursor.getPosition());

        controls.bindUpEvent(this::cursorUp);
        controls.bindDownEvent(this::cursorDown);
        controls.bindConfirmEvent(this::confirm);
        controls.bindCancelEvent(this::cancel);

    }

    private void cursorUp() {

        if (currentCursorPosition == CursorPosition.START) {
            currentCursorPosition = CursorPosition.EXIT;
            cursor.getPosition().setLocation(originalCursorPosition.x, originalCursorPosition.y + GameScale.yScale(40));
        } else {

            currentCursorPosition = currentCursorPosition == CursorPosition.OPTION
                    ? CursorPosition.START
                    : CursorPosition.OPTION;
            cursor.getPosition().translate(0, -20);

        }

    }

    private void cursorDown() {

        if (currentCursorPosition == CursorPosition.EXIT) {
            currentCursorPosition = CursorPosition.START;
            cursor.getPosition().setLocation(originalCursorPosition);
        } else {

            cursor.getPosition().translate(0, 20);
            currentCursorPosition = currentCursorPosition == CursorPosition.OPTION
                    ? CursorPosition.EXIT
                    : CursorPosition.OPTION;

        }

    }

    private void confirm() {

        if (currentCursorPosition == CursorPosition.START) {
            GameStateMachine.getInstance().setActiveState(State.GAME_PLAY);
        } else if (currentCursorPosition == CursorPosition.OPTION) {
            System.out.println("OPEN OPTIONS MENU");
        } else if (currentCursorPosition == CursorPosition.EXIT) {
            System.exit(0);//TODO cleaner exit, like saving stuff
        }
    }

    private void cancel() {

    }

    public void update() {
        controls.update();
    }

}
