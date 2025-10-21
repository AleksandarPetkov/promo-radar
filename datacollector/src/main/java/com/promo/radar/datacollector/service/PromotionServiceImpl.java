package com.promo.radar.datacollector.service;

import com.promo.radar.datacollector.dto.Event;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Override
    public Event processPromotion() {
        Event event = new Event("1.0", "Test kafka connection..");
        return event;
    }
}
