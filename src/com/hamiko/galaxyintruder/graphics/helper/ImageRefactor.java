package com.hamiko.galaxyintruder.graphics.helper;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class ImageRefactor {

    /**
     * Get a resized version of inputImage
     *
     * @param inputImage Input image
     * @return Resized image
     */
    public static BufferedImage resize(BufferedImage inputImage, int newWidth, int newHeight) {

        BufferedImage outputImage = createCompatibleImage(
                new BufferedImage(newWidth, newHeight, inputImage.getType()));

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return outputImage;

    }

    public static BufferedImage flipHorizontally(BufferedImage inputImage) {

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-inputImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(inputImage, null);

    }

    public static BufferedImage rotateImage(BufferedImage inputImage) {

        AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
        tx.translate(-inputImage.getWidth(null), -inputImage.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(inputImage, null);

    }

    public static BufferedImage createCompatibleImage(BufferedImage image) {

        // obtain the current system graphical settings
        GraphicsConfiguration gfxConfig = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getDefaultScreenDevice().
                getDefaultConfiguration();

        /*
         * if image is already compatible and optimized for current system
         * settings, simply return it
         */
        if (image.getColorModel().equals(gfxConfig.getColorModel())) {
            return image;
        }

        // image is not optimized, so getState a new image that is
        BufferedImage newImage = gfxConfig.createCompatibleImage(
                image.getWidth(), image.getHeight(), image.getTransparency()
        );

        // get the graphics context of the new image to draw the old image on
        Graphics2D g2d = (Graphics2D) newImage.getGraphics();

        // actually draw the image and dispose of context no longer needed
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        // return the new optimized image
        return newImage;

    }

}
