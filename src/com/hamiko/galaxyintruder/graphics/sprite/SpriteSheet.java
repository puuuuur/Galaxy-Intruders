package com.hamiko.galaxyintruder.graphics.sprite;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.window.Screen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

    private final int SCALE_32_BIT = 1;

    protected BufferedImage testImage;

    protected Sprite[][] sprites;
    protected Screen screen = Screen.getInstance();

    public SpriteSheet(String uri, int bit, int xTiles, int yTiles) {

        sprites = new Sprite[yTiles][xTiles];

        try {
            createSpritesFromSpriteSheet(loadImage(uri), bit, xTiles, yTiles);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createSpritesFromSpriteSheet(BufferedImage spriteSheet, int bit, int xTiles, int yTiles) {

        int offsetX = 0;
        int offsetY = 0;

        for (int y = 0; y < yTiles; y++) {

            for (int x = 0; x < xTiles; x++) {

                BufferedImage image = spriteSheet.getSubimage(offsetX, offsetY, bit, bit);
                sprites[y][x] = new Sprite(image);

                offsetX += bit;

            }

            offsetX = 0;
            offsetY += bit;

        }

    }

    private BufferedImage loadImage(String uri) throws IOException {

        BufferedImage img = ImageIO.read(new File(uri));

        Screen screen = Screen.getInstance();

        int width = (int) (img.getWidth() * screen.xScale() * SCALE_32_BIT);
        int height = (int) (img.getHeight() * screen.yScale() * SCALE_32_BIT);
        //spriteSheet =  img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        return ImageRefactor.resize(img, width, height);

    }

    public Sprite[][] getSprites() {
        return sprites;
    }

    public Sprite getSprite(int y, int x) {
        return sprites[y][x];
    }

}
