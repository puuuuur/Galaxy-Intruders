package com.hammiko.galaxyintruder.window;

import com.hammiko.galaxyintruder.graphics.view.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Screen extends JFrame implements Runnable {

    private static Screen instance;

    public class Constant {
        public static final int BASE_WIDTH = 1920;
        public static final int BASE_HEIGHT = 1080;
    }

    private double xScale;
    private double yScale;

    private boolean isRunning = false;
    private boolean isFullScreen = false;
    private static Dimension fullScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private ResolutionMap resolutions = new ResolutionMap();

    public static Screen getInstance() {

        if (Screen.instance == null) {
            Screen.instance = new Screen();
        }

        return Screen.instance;

    }

    private Screen() {

        //setUndecorated(true);
        //TODO remove deco when full screen on
        //TODO if a set resolution exceeds the possible one, prevent OR scale down to monitor nativ
        //TODO support ultra wide screen mode?

        this.createScreenSize(resolutions.getResolution(Resolution._720p));
        setResizable(false);
        setFocusable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.yellow);

    }

    public void createScreenSize(Dimension screenSize) {
        setPreferredSize(screenSize);
        setScreenScale(screenSize);
        pack();
    }

    private void setScreenScale(Dimension screenSize) {
        xScale = screenSize.width / (double)Constant.BASE_WIDTH;
        yScale = screenSize.height / (double)Constant.BASE_HEIGHT;
    }

    public void setActiveView(GameView view) {
        setContentPane(view);
        pack();
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
            this.repaint();
        }

    }

    public double xScale() {
        return xScale;
    }

    public double yScale() {
        return yScale;
    }

}
