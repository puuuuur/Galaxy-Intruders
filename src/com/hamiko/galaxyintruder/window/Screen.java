package com.hamiko.galaxyintruder.window;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.physics.GameScale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame implements Runnable {

    private final String GAME_TITEL = "Galaxy Intruders";

    private static Screen instance = new Screen();

    private GameView activeView;

    private Resolution currentResolution = Resolution._720p;

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

    public Canvas canvas = new Canvas();

    private Screen() {

//        setUndecorated(true);
        setResizable(false);
        setFocusable(true);

        Dimension dimension = resolutions.getResolution(currentResolution);

        canvas.setSize(dimension);
        add(canvas);

        GameScale.setScaling(
                dimension.width / (double) Constant.BASE_WIDTH,
                dimension.height / (double) Constant.BASE_HEIGHT
        );

        canvas.requestFocus();
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void createScreenSize(Dimension screenSize) {
        //  setPreferredSize(screenSize);
        setGameScale(screenSize);
        pack();
    }

    private void setGameScale(Dimension screenSize) {
        GameScale.setScaling(
                screenSize.width / (double) Constant.BASE_WIDTH,
                screenSize.height / (double) Constant.BASE_HEIGHT
        );
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
        g.setColor(new Color(48, 54, 85));
        g.fillRect(0, 0, getWidth(), getHeight());

        activeView.render(g);

        g.dispose();
        bs.show();

    }

    public void updateUPS(int ups) {
        this.setTitle(GAME_TITEL + " UPS: " + ups);
    }

    public Dimension getCanvasSize() {
        return canvas.getSize();
    }

}
