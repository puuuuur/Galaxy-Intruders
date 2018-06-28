package com.hamiko.galaxyintruder.graphics.window;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.system.PerformanceTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame {

    private final Color BACKGROUND_COLOR = Color.BLACK;
    private static Screen instance = new Screen();

    private GameView activeView;
    private ResolutionMap resolutions = new ResolutionMap();
    private Resolution currentResolution = Resolution._720p;

    private boolean isFullScreen = false;

    public class Constant {
        final static int BASE_WIDTH = 924;
        final static int BASE_HEIGHT = 520;
    }


    public static Screen getInstance() {
        return Screen.instance;
    }

    private Canvas canvas = new Canvas();

    private Screen() {
    }

    public void init() {

        setResizable(false);
        setFocusable(true);
        setBackground(Color.BLACK);
        setTitle("Galaxy Intruders");

        Dimension dimension = getResolution();

        canvas.setBackground(BACKGROUND_COLOR);
        canvas.setSize(dimension);
        add(canvas);

        GameScale.setScaling(
                dimension.width / (double) Constant.BASE_WIDTH,
                dimension.height / (double) Constant.BASE_HEIGHT
        );

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        canvas.requestFocus();

    }

    public void setGameView(GameView view) {
        this.activeView = view;
    }

    public void setOnCloseEvent(OnCloseEvent event) {

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                event.fire();
                Frame frame = (Frame) e.getSource();
                frame.dispose();
                System.exit(0);

            }

        });

    }

    public void render() {

        BufferStrategy bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());

        activeView.render(g);

        PerformanceTracker.render(g);
        g.dispose();
        bs.show();

    }

    public Canvas getCanvas() {
        return canvas;
    }

    private Dimension getResolution() {

        Dimension resolution;

        if (isFullScreen) {
            setUndecorated(true);
            resolution = Toolkit.getDefaultToolkit().getScreenSize();
        } else {
            resolution = resolutions.getResolution(currentResolution);
        }

        return resolution;

    }

    public void setFullScreen(boolean fullScreen) {
        isFullScreen = fullScreen;
    }

    /**
     * @return Screen width with calculated with scaling factor
     */
    public int getTrueWidth(){
        return Constant.BASE_WIDTH / GameScale.SCALING_FACTOR;
    }

    /**
     * @return Screen height with calculated with scaling factor
     */
    public int getTrueHeight(){
        return Constant.BASE_HEIGHT / GameScale.SCALING_FACTOR;
    }

}
