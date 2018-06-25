package com.hamiko.galaxyintruder.system;

import com.hamiko.galaxyintruder.graphics.window.Screen;
import com.hamiko.galaxyintruder.physics.GameScale;

import java.awt.*;

public class PerformanceTracker {

    private static Font font = new Font("Press Start 2P", Font.PLAIN, GameScale.xScale(5));
    private static int ups;
    private static int fps;

    public static void render(Graphics g) {

        g.setColor(Color.ORANGE);
        g.setFont(font);
        g.drawString(
                "UPS: " + ups + " FPS: " + fps,
                Screen.getInstance().getCanvas().getWidth() - GameScale.xScale(80),
                GameScale.xScale(6)
        );

    }

    public static void updateValues(int ups, int fps) {
        PerformanceTracker.ups = ups;
        PerformanceTracker.fps = fps;
    }

}
