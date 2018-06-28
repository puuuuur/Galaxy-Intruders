package com.hamiko.galaxyintruder.scenes;

import com.hamiko.galaxyintruder.graphics.GUI.MenuControls;
import com.hamiko.galaxyintruder.graphics.GUI.MenuCursor;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class PauseMenu {

    private MenuControls controls;
    private MenuCursor cursor;

    private enum CursorPosition {START, RESUME, OPTION, EXIT}

    private CursorPosition currentCursorPosition = CursorPosition.START;
    private Position originalCursorPosition;

    public PauseMenu(MenuControls controls, MenuCursor cursor) {

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
            cursor.getPosition().setLocation(originalCursorPosition.x, originalCursorPosition.y + GameScale.yScale(60));
        } else {

            cursor.getPosition().translate(0, -20);

            if (currentCursorPosition == CursorPosition.EXIT) {
                currentCursorPosition = CursorPosition.OPTION;
            } else if (currentCursorPosition == CursorPosition.OPTION) {
                currentCursorPosition = CursorPosition.RESUME;
            } else if (currentCursorPosition == CursorPosition.RESUME) {
                currentCursorPosition = CursorPosition.START;
            }

        }

    }

    private void cursorDown() {

        if (currentCursorPosition == CursorPosition.EXIT) {
            currentCursorPosition = CursorPosition.START;
            cursor.getPosition().setLocation(originalCursorPosition);
        } else {

            cursor.getPosition().translate(0, 20);

            if (currentCursorPosition == CursorPosition.START) {
                currentCursorPosition = CursorPosition.RESUME;
            } else if (currentCursorPosition == CursorPosition.RESUME) {
                currentCursorPosition = CursorPosition.OPTION;
            } else if (currentCursorPosition == CursorPosition.OPTION) {
                currentCursorPosition = CursorPosition.EXIT;
            }

        }

    }

    private void confirm() {

        switch (currentCursorPosition) {
            case START:
                GameStateMachine.getInstance().restartGameState();
            case RESUME:
                GameStateMachine.getInstance().setActiveState(State.GAME_PLAY);
                break;
            case OPTION:
                System.out.println("OPEN OPTIONS MENU");//TODO implement option menu (volume, difficulty, resolution etc.)
                break;
            case EXIT:
                System.exit(0);//TODO cleaner exit, like saving stuff
                break;
        }

    }

    private void cancel() {
        //TODO back from sub menu
    }

    public void update() {
        controls.update();
    }

}

