package com.hammiko.galaxyintruder.window;

import com.hammiko.galaxyintruder.graphics.view.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Screen extends JFrame implements Runnable {

    private static int width = 300;
    private static int height = width / 16 * 9;
    private static int scale = 3;

    private boolean isRunning = false;

    public Screen() {

        /* TODO Use this for full screen mode after building proper game exit
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setUndecorated(true);
         */

        Dimension screenSize = new Dimension(width * scale, height * scale);

        setPreferredSize(screenSize);
        setResizable(false);
        setFocusable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.yellow);

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

}
