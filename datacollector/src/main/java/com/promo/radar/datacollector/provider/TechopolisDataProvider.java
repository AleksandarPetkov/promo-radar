package com.promo.radar.datacollector.provider;

import org.springframework.stereotype.Service;

@Service
public class TechopolisDataProvider implements ExternalDataProvider {

    @Override
    public String collectCurrentPromotion() {
        return "";
    }
}
