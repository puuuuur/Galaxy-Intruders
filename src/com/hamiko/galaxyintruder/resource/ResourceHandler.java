package com.hamiko.galaxyintruder.resource;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResourceHandler {

    private static Map<String, BufferedImage> imageCache = new HashMap<>();

    /**
     * Get an image resource. Resourse is stored
     *
     * @param uri
     * @return
     */
    public static BufferedImage getImage(String uri) {

        BufferedImage image = imageCache.get(uri);

        if (image == null) {

            try {

                image = ImageRefactor.createCompatibleImage(
                        ImageIO.read(new File(uri))
                );

                imageCache.put(uri, image);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return image;

    }

    /**
     * Define here stuff to preload
     */
    public static void preload() {
        loadFonts();
    }

    private static void loadFonts() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try {

            Font ps2p = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/PressStart2P.ttf"));
            ge.registerFont(ps2p);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

}
