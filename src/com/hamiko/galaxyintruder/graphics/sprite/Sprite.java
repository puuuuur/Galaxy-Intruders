package com.hamiko.galaxyintruder.graphics.sprite;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.physics.ScaledDimension;
import com.hamiko.galaxyintruder.resource.ResourceHandler;

import java.awt.image.BufferedImage;

public class Sprite {

    private BufferedImage image;

    private ScaledDimension dimension;

    public Sprite(String uri) {

        BufferedImage img = ResourceHandler.getImage(uri);

        this.image = ImageRefactor.createCompatibleImage(img);
        this.dimension = new ScaledDimension(image.getWidth(), image.getHeight());


    }

    public Sprite(BufferedImage image) {
        this.image = image;
        this.dimension = new ScaledDimension(image.getWidth(), image.getHeight());
    }

    public BufferedImage getImage() {
        return image;
    }

    public ScaledDimension getDimension() {
        return dimension;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
