package com.hamiko.galaxyintruder.physics;

import java.awt.*;

public class Position extends Point {

    public Position() {
        super();
    }

    public Position(int x, int y) {
        super((int)(x * GameScale.xScale()), (int)(y * GameScale.yScale()));
    }

    public Position(Position position) {
        super(position.x, position.y);
    }

    public void translate(int dx, int dy) {
        super.translate((int) (dx + GameScale.xScale()), (int) (dy + GameScale.yScale()));
    }

}
