package com.arndew.badrespawn.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;


public interface BedAnchorRespawnCallback {
    Event<BedAnchorRespawnCallback> EVENT = EventFactory.createArrayBacked(BedAnchorRespawnCallback.class,
            (listeners) -> () -> {
                for (BedAnchorRespawnCallback event : listeners) {
                    event.onBlockAnchorRespawn();
                }
            });

    void onBlockAnchorRespawn();
}
