package com.promo.radar.datacollector.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionCollector {

    private static final Logger log = LoggerFactory.getLogger(PromotionCollector.class);
    private static final String CRON_EVERY_FIVE_MINUTES = "0 */5 * * * *";


    @Value("${provider.api.layer.names}")
    private List<String> providerLayerNames;

    public void collectPromotion() {

    }
}
