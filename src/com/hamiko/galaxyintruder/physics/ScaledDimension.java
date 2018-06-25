package com.hamiko.galaxyintruder.physics;

import java.awt.*;

public class ScaledDimension extends Dimension {

    public ScaledDimension() {
        super();
    }

    public ScaledDimension(int width, int height) {
        super((int) (width * GameScale.xScale()), (int) (height * GameScale.yScale()));
    }

    public ScaledDimension(Dimension dimension) {
        super((int) (dimension.width * GameScale.xScale()), (int) (dimension.height * GameScale.yScale()));
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize((int) (width * GameScale.xScale()), (int) (height * GameScale.yScale()));

    }

    @Override
    public void setSize(Dimension dimension) {
        super.setSize((int) (dimension.width * GameScale.xScale()), (int) (dimension.height * GameScale.yScale()));

    }

    /**
     * Scaled variant of setSize, will not rescale
     *
     * @param sd Provided Scaled dimension will not add new scaling
     */
    public ScaledDimension setSize(ScaledDimension sd) {
        super.setSize(sd.width, sd.height);
        return this;
    }

}
