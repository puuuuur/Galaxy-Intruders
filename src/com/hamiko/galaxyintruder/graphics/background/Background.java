package com.hamiko.galaxyintruder.graphics.background;

import com.hamiko.galaxyintruder.graphics.Drawable;
import com.hamiko.galaxyintruder.graphics.GameGraphics;
import com.hamiko.galaxyintruder.graphics.elements.GraphicElement;
import com.hamiko.galaxyintruder.graphics.helper.ImageRefactor;
import com.hamiko.galaxyintruder.graphics.window.Screen;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;
import com.hamiko.galaxyintruder.resource.ResourceHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GraphicElement implements Drawable {

    private BufferedImage image;

    private final String imageUri = "res/background/background.png";

    public Background(Position position) {
        super(position);

        Dimension canvasSize = Screen.getInstance().getCanvas().getSize();
        BufferedImage backgroundImage = ResourceHandler.getImage(imageUri);

        int newHeight = (int) ((canvasSize.getWidth() / canvasSize.getHeight()) * backgroundImage.getWidth());
        image = ImageRefactor.resize(backgroundImage, (int) canvasSize.getWidth(), newHeight);

    }

    public void update() {
        this.getPosition().y += (5 * GameScale.interpolation());
    }

    @Override
    public void render(GameGraphics graphics) {
        graphics.drawBackground(this);
    }

    public BufferedImage getImage() {
        return image;
    }

}
