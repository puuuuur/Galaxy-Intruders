package com.hamiko.galaxyintruder.graphics.sprite;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.physics.ScaledDimension;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite  {

    private BufferedImage image;

    private ScaledDimension dimension;

    public Sprite(String uri){

        try {

            BufferedImage img = ImageIO.read(new File(uri));

            this.image = ImageRefactor.createCompatibleImage(img);
            this.dimension = new ScaledDimension(image.getWidth(), image.getHeight());

        } catch (IOException ex) {
            // TODO handle exception...
        }

    }

    public Sprite(BufferedImage image){
       this.image = image;
       this.dimension = new ScaledDimension(image.getWidth(), image.getHeight());
    }

    public BufferedImage getImage() {
        return image;
    }

    public ScaledDimension getDimension() {
        return dimension;
    }

}
