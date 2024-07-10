package com.arndew.badrespawn.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class HallucinationEffectEvents {
    public static final Event<HallucinationApplied> APPLIED = EventFactory.createArrayBacked(HallucinationApplied.class, (listeners) -> () -> {
            for (HallucinationApplied event : listeners) {
                    event.hallucinationApplied();
            }
    });

    public static final Event<HallucinationRemoved> REMOVED = EventFactory.createArrayBacked(HallucinationRemoved.class, (listeners) -> () -> {
        for (HallucinationRemoved event : listeners) {
            event.hallucinationRemoved();
        }
    });

    @FunctionalInterface
    public interface HallucinationApplied {
        void hallucinationApplied();
    }

    @FunctionalInterface
    public interface HallucinationRemoved {
        void hallucinationRemoved();
    }
}
