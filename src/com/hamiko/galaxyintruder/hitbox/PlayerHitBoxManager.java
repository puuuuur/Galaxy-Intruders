package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.entities.player.Player;

import java.awt.*;

public class PlayerHitBoxManager extends HitBoxManager {


    private Player player;

    public PlayerHitBoxManager(Player player) {

        this.player = player;

        Point playerPosition = player.getPosition();
        int yTranslate = playerPosition.y - player.getHeight() / 4 - 10;
        HitBox box = new HitBox(playerPosition.x, yTranslate, 40, player.getHeight() / 2);

        box.setOffsetY(-44);
        hitboxes.add(box);

        yTranslate = playerPosition.y + player.getHeight() / 4 + 30;

        box = new HitBox(playerPosition.x, yTranslate, player.getWidth(), player.getHeight() / 2);
        box.setOffsetY(65);
        hitboxes.add(box);

    }

    @Override
    public Player getEntity() {
        return player;
    }

}
