package com.promo.radar.datacollector.scheduler;

import com.promo.radar.datacollector.service.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionCollector {

    private static final Logger log = LoggerFactory.getLogger(PromotionCollector.class);
//    private static final String CRON_EVERY_FIVE_MINUTES = "0 */5 * * * *";
    private static final String CRON_EVERY_THIRTY_SECONDS = "*/30 * * * * *";

    private final PromotionService promotionService;


    @Value("${provider.api.layer.names}")
    private List<String> providerLayerNames;

    public PromotionCollector(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void collectPromotion() {
        promotionService.processPromotion();
    }
}
