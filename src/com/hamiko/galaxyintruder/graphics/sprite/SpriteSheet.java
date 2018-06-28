package com.hamiko.galaxyintruder.graphics.sprite;

import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.resource.ResourceHandler;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private Sprite[][] sprites;

    SpriteSheet(String uri, int bit, int xTiles, int yTiles, double scale) {
        sprites = new Sprite[yTiles][xTiles];
        createSpritesFromSpriteSheet(loadImage(uri), bit, xTiles, yTiles);
    }

    public SpriteSheet(String uri, int bit, int xTiles, int yTiles) {//TODO remove public
       this(uri, bit, xTiles, yTiles, 1);
    }

    private void createSpritesFromSpriteSheet(BufferedImage spriteSheet, int size, int xTiles, int yTiles) {
        createSpritesFromSpriteSheet(spriteSheet, size, size, xTiles, yTiles);
    }

    private void createSpritesFromSpriteSheet(BufferedImage spriteSheet, int width, int height, int xTiles, int yTiles) {

        int offsetX = 0;
        int offsetY = 0;

        for (int y = 0; y < yTiles; y++) {

            for (int x = 0; x < xTiles; x++) {

                BufferedImage image = spriteSheet.getSubimage(offsetX, offsetY, width, height);
                image = ImageRefactor.createCompatibleImage(image);
                sprites[y][x] = new Sprite(image);
                offsetX += width;

            }

            offsetX = 0;
            offsetY += height;

        }

    }

    private BufferedImage loadImage(String uri) {
        BufferedImage img = ResourceHandler.getImage(uri);
        return ImageRefactor.createCompatibleImage(img);
    }

    public Sprite getSprite(int y, int x) {
        return sprites[y][x];
    }

}
