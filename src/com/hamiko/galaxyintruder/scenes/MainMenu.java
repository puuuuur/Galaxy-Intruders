package com.hamiko.galaxyintruder.scenes;

import com.hamiko.galaxyintruder.graphics.GUI.MenuControls;
import com.hamiko.galaxyintruder.graphics.GUI.MenuCursor;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.statemachine.GameStateMachine;
import com.hamiko.galaxyintruder.statemachine.State;

public class MainMenu {

    private MenuControls controls;
    private MenuCursor cursor;

    private enum CursorPosition {START, OPTION, EXIT}

    private CursorPosition currentCursorPosition = CursorPosition.START;


    public MainMenu(MenuControls controls, MenuCursor cursor) {

        this.controls = controls;
        this.cursor = cursor;

        controls.bindUpEvent(this::cursorUp);
        controls.bindDownEvent(this::cursorDown);
        controls.bindConfirmEvent(this::confirm);
        controls.bindCancelEvent(this::cancel);

    }

    private void cursorUp() {
        // cursor.getPosition().move(cursor.getPosition().x, cursor.getPosition().y - GameScale.yScale(20));

        if (currentCursorPosition == CursorPosition.START) {
            currentCursorPosition = CursorPosition.EXIT;
            cursor.getPosition().move(cursor.getPosition().x, cursor.getPosition().y + GameScale.yScale(40));
        } else {
            currentCursorPosition = currentCursorPosition == CursorPosition.OPTION ? CursorPosition.START : CursorPosition.OPTION;
            cursor.getPosition().move(cursor.getPosition().x, cursor.getPosition().y - GameScale.yScale(20));
        }

    }

    private void cursorDown() {

        if (currentCursorPosition == CursorPosition.EXIT) {
            currentCursorPosition = CursorPosition.START;
            cursor.getPosition().move(cursor.getPosition().x, cursor.getPosition().y - GameScale.yScale(40));
        } else {
            currentCursorPosition = currentCursorPosition == CursorPosition.OPTION ? CursorPosition.EXIT : CursorPosition.OPTION;
            cursor.getPosition().move(cursor.getPosition().x, cursor.getPosition().y + GameScale.yScale(20));
        }

    }

    private void confirm() {

        if (currentCursorPosition == CursorPosition.START) {
            GameStateMachine.getInstance().setActiveState(State.GAME_PLAY);
        } else if (currentCursorPosition == CursorPosition.OPTION) {
            System.out.println("OPEN OPTIONS MENU");
        }else if (currentCursorPosition == CursorPosition.EXIT) {
            System.exit(0);//TODO cleaner exit, like saving shit
        }
    }

    private void cancel() {

    }

    public void update() {
        controls.update();
    }

}
