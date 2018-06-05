package com.hamiko.galaxyintruder.graphics.window;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.system.PerformanceTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame implements Runnable {

    private static Screen instance = new Screen();
    private GameView activeView;
    private Resolution currentResolution = Resolution._270p;
    //private final Color BACKGROUND_COLOR = new Color(48, 54, 85);

    private final Color BACKGROUND_COLOR = Color.BLACK;

    public class Constant {
        final static int BASE_WIDTH = 924;
        final static int BASE_HEIGHT = 520;
    }

    private boolean isRunning = false;
    private boolean isFullScreen = false;
    private static Dimension fullScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private ResolutionMap resolutions = new ResolutionMap();

    public static Screen getInstance() {
        return Screen.instance;
    }

    private Canvas canvas = new Canvas();

    private Screen() {

        setUndecorated(true);
        setResizable(false);
        setFocusable(true);
        setBackground(Color.BLACK);
        setTitle("Galaxy Intruders");

        //TODO add native resolution to resolution map
        Dimension dimension = resolutions.getResolution(currentResolution);
        Dimension nativeResolution = Toolkit.getDefaultToolkit().getScreenSize();
        dimension = nativeResolution;
        
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

                isRunning = false;
                event.fire();
                Frame frame = (Frame) e.getSource();
                frame.dispose();

            }

        });

    }

    @Override
    public void run() {

        isRunning = true;

        while (isRunning) {
            render();
        }

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

}
