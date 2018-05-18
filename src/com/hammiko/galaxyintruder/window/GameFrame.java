package com.hammiko.galaxyintruder.window;


import com.hammiko.galaxyintruder.graphics.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {

    private static int width = 300;
    private static int height = width / 16 * 9;
    private static int scale = 3;

    public GameFrame(){

        setPreferredSize(new Dimension(width * scale, height * scale));
        setResizable(false);
        setFocusable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void setActiveView(GameView view){
        setContentPane(view);
    }

    public void setOnCloseEvent(OnCloseEvent event){

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                event.fire();
                Frame frame = (Frame) e.getSource();
                frame.dispose();
            }

        });

    }

}
