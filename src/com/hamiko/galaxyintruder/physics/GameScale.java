package com.hamiko.galaxyintruder.physics;

public class GameScale {

    public final static int SCALING_FACTOR = 2;

    private static double xScale;
    private static double yScale;

    private static double frameInterpolation = 1;

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

    /**
     * Returns value scaled by x scale
     * @param val Value to scale
     * @return Scalded value
     */
    public static int xScale(int val) {
        return (int)(xScale * val);
    }

    /**
     * Returns value scaled by y scale
     *
     * @param val Value to scale
     * @return Scalded value
     */
    public static int yScale(int val) {
        return (int)(yScale * val);
    }

    public static double interpolation() {
        return frameInterpolation;
    }

    public static void setFrameInterpolation(double frameInterpolation) {
        GameScale.frameInterpolation = frameInterpolation;
    }

}
