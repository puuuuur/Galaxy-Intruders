package com.hamiko.galaxyintruder.graphics.sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Handle sprite sheet creation
 */
public class SpriteSheetContainer {

    private static Map<String, SpriteSheet> spriteSheetCache = new HashMap<>();

    public static SpriteSheet getSpriteSheet(String uri, int bit, int xTiles, int yTiles) {

        SpriteSheet spriteSheet = spriteSheetCache.get(uri);

        if (spriteSheet == null) {
            spriteSheet = new SpriteSheet(uri, bit, xTiles, yTiles);
            spriteSheetCache.put(uri, spriteSheet);
        }

        return spriteSheet;

    }

}
