package com.hamiko.galaxyintruder.graphics.sprite;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.window.Screen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite  {

    private BufferedImage image;

    public Sprite(String uri){

        try {
            BufferedImage img = ImageIO.read(new File(uri));

            Screen screen = Screen.getInstance();
            final int SCALE_32_BIT = 4;
            int width = (int)(img.getWidth()  * screen.xScale() * SCALE_32_BIT);
            int height = (int)(img.getHeight()  * screen.yScale() * SCALE_32_BIT);
            image = ImageRefactor.resize(img, width, height);

        } catch (IOException ex) {
            // handle exception...
        }

    }

    public Sprite(BufferedImage image){
       this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

}
