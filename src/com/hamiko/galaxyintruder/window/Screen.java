package com.hamiko.galaxyintruder.window;

import com.hamiko.galaxyintruder.graphics.view.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Screen extends JFrame implements Runnable {

    private static Screen instance = new Screen();

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
        return Screen.instance;
    }

    private Screen() {

        //setUndecorated(true);
        //TODO remove deco when full screen on
        //TODO if a set resolution exceeds the possible one, prevent OR scale down to monitor nativ
        //TODO support ultra wide screen mode?

        this.createScreenSize(resolutions.getResolution(Resolution._1080p));
        setResizable(false);
        setFocusable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.black);

    }

    public void createScreenSize(Dimension screenSize) {
        setPreferredSize(screenSize);
        setScreenScale(screenSize);
        pack();
    }

    private void setScreenScale(Dimension screenSize) {
        xScale = screenSize.width / (double) Constant.BASE_WIDTH;
        yScale = screenSize.height / (double) Constant.BASE_HEIGHT;
    }


    private GameView view;

    public void setActiveView(GameView view) {
        this.view = view;
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

            BufferStrategy bs = getBufferStrategy();

            if (bs == null) {
                createBufferStrategy(3);
                continue;
            }

            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());


            if (view != null) {
                view.render(g);
                //view.repaint();
            }

            g.dispose();
            bs.show();

        }

    }

    public double xScale() {
        return xScale;
    }

    public double yScale() {
        return yScale;
    }

}
