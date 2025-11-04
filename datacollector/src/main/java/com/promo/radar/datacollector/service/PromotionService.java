package com.promo.radar.datacollector.service;

import com.promo.radar.datacollector.dto.Event;
import com.promo.radar.datacollector.dto.Message;

public interface PromotionService {

    Event processPromotion();

    Message sendKafkaMessage(Message topic);
}
