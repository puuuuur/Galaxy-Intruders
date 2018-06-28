package com.hamiko.galaxyintruder.graphics.GUI;

import com.hamiko.galaxyintruder.input.OnButtonPressed;
import com.hamiko.galaxyintruder.input.MenuInput;

/**
 * Input decorator for main menu. Registers button pressing only once.
 */
public class MenuControls {

    private MenuInput input;

    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean confirmPressed = false;
    private boolean cancelPressed = false;

    private OnButtonPressed[] events = new OnButtonPressed[4];

    private enum Event {UP, DOWN, CONFIRM, CANCEL}

    public MenuControls(MenuInput input) {
        this.input = input;
    }

    public void update() {

        if (input.up() && !upPressed) {
            upPressed = true;
            up();
        } else if (!input.up() && upPressed) {
            upPressed = false;
        }

        if (input.down() && !downPressed) {
            downPressed = true;
            down();
        } else if (!input.down() && downPressed) {
            downPressed = false;
        }

        if (input.confirm() && !confirmPressed) {
            confirmPressed = true;
            confirm();
        } else if (!input.confirm() && confirmPressed) {
            confirmPressed = false;
        }

        if (input.cancel() && !cancelPressed) {
            cancelPressed = true;
            cancel();
        } else if (!input.cancel() && cancelPressed) {
            cancelPressed = false;
        }

    }

    private void up() {
        events[Event.UP.ordinal()].fire();
    }

    private void down() {
        events[Event.DOWN.ordinal()].fire();
    }

    private void confirm() {
        events[Event.CONFIRM.ordinal()].fire();
    }

    private void cancel() {
        events[Event.CANCEL.ordinal()].fire();

    }

    public void bindUpEvent(OnButtonPressed event) {
        events[Event.UP.ordinal()] = event;
    }

    public void bindDownEvent(OnButtonPressed event) {
        events[Event.DOWN.ordinal()] = event;
    }

    public void bindConfirmEvent(OnButtonPressed event) {
        events[Event.CONFIRM.ordinal()] = event;
    }

    public void bindCancelEvent(OnButtonPressed event) {
        events[Event.CANCEL.ordinal()] = event;
    }

}
