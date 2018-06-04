package com.hamiko.galaxyintruder.physics;

import java.awt.*;

public class Position extends Point {

    public Position() {
        super();
    }

    public Position(int x, int y) {
        super(GameScale.xScale(x), GameScale.yScale(y));
    }

    public Position(Position position) {
        super(position.x, position.y);
    }

    public void translate(int dx, int dy) {
        super.translate(GameScale.xScale(dx),  + GameScale.yScale(dy));
    }

}
