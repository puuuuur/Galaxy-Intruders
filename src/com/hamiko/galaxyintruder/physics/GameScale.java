package com.hamiko.galaxyintruder.physics;

public class GameScale {

    private final static int SCALING_FACTOR = 2;

    private static double xScale;
    private static double yScale;

    private final static GameScale instance = new GameScale();

    private GameScale() {
    }

    public static void setScaling(double xScale, double yScale) {
        GameScale.xScale = xScale * SCALING_FACTOR;
        GameScale.yScale = yScale * SCALING_FACTOR;
    }

    public static GameScale instance() {
        return instance;
    }

    public static double xScale() {
        return xScale;
    }

    public static double yScale() {
        return yScale;
    }

    public static int xScale(int val) {
        return (int)(xScale * val);
    }

    public static int yScale(int val) {
        return (int)(yScale * val);
    }

}
