package com.hamiko.galaxyintruder.graphics.helper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRefactor {

    /**
     * Get a resized version of inputImage
     *
     * @param inputImage   Input image
     * @param scaledWidth  Output width
     * @param scaledHeight Output height
     * @return Resized image
     */
    public static BufferedImage resize(BufferedImage inputImage, int scaledWidth, int scaledHeight) {

        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;

    }

}
