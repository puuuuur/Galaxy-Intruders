package com.hamiko.galaxyintruder.hitbox;

import com.hamiko.galaxyintruder.entities.player.Player;
import com.hamiko.galaxyintruder.physics.GameScale;
import com.hamiko.galaxyintruder.physics.Position;

public class PlayerHitBoxManager extends HitBoxManager {


    public PlayerHitBoxManager(Player player) {
        super(player);

        Position playerPosition = player.getPosition();

        HitBox cockpit = new HitBox(playerPosition, player.getHeight() / 4, player.getHeight() / 2);
        cockpit.setOffsetY(- player.getHeight() / 2 + GameScale.xScale(4));

        hitboxes.add(cockpit);

        HitBox shipTorso = new HitBox(playerPosition, player.getWidth(), player.getHeight() / 2);
        shipTorso.setOffsetY(player.getHeight() / 2);
        hitboxes.add(shipTorso);

    }

}
