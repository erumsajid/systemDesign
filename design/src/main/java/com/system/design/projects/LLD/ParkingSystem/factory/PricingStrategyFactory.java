package com.system.design.projects.LLD.ParkingSystem.factory;

import com.system.design.projects.LLD.ParkingSystem.enums.PricingStrategyType;
import com.system.design.projects.LLD.ParkingSystem.strategy.pricing.PricingStrategy;
import com.system.design.projects.LLD.ParkingSystem.strategy.pricing.TimeBasedPricing;

public class PricingStrategyFactory {
    public static PricingStrategy get(PricingStrategyType type) {
        return switch (type) {
            case TIME_BASED -> new TimeBasedPricing();
            case EVENT_BASED -> throw new RuntimeException("Not supported yet");
        };
    }
}
