package com.hamiko.galaxyintruder.window;

import com.hamiko.galaxyintruder.graphics.view.GameView;
import com.hamiko.galaxyintruder.physics.GameScale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class Screen extends JPanel implements Runnable {

    private final String GAME_TITEL = "Galaxy Intruders";

    private static Screen instance = new Screen();
    private GameView activeView;

    private Resolution currentResolution = Resolution._1080p;

    JFrame frame = new JFrame();

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

    private Screen() {

        //setUndecorated(true);
        this.createScreenSize(resolutions.getResolution(currentResolution));

        // add(panel);
        frame.add(this);
        frame.setContentPane(this);
        frame.setSize(resolutions.getResolution(currentResolution));
        System.out.println(resolutions.getResolution(currentResolution));
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBackground(Color.black);

    }

    public void createScreenSize(Dimension screenSize) {
        setPreferredSize(screenSize);
        setGameScale(screenSize);
        frame.pack();
    }

    private void setGameScale(Dimension screenSize) {
        GameScale.setScaling(
                screenSize.width / (double) Constant.BASE_WIDTH,
                screenSize.height / (double) Constant.BASE_HEIGHT
        );
    }

    JPanel panel = new JPanel();

    public void setGameView(GameView view) {

        add(view);
        view.setSize(getSize());
        this.activeView = view;
    }

    public void setOnCloseEvent(OnCloseEvent event) {

        frame.addWindowListener(new WindowAdapter() {

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

        BufferStrategy bs = activeView.getBufferStrategy();

        if (bs == null) {
            activeView.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(48, 54, 85));
        g.fillRect(0, 0, getWidth(), getHeight());

        activeView.render(g);

        panel.paintComponents(activeView.getGraphics());

        g.dispose();
        bs.show();

    }

    public void updateUPS(int ups) {
        this.frame.setTitle(GAME_TITEL + " UPS: " + ups);
    }

}
