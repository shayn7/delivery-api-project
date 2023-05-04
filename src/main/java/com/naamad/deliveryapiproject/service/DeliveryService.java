package com.naamad.deliveryapiproject.service;

import com.naamad.deliveryapiproject.dto.DeliveryRequest;

public interface DeliveryService {
    String bookDelivery(DeliveryRequest deliveryRequest);

    void cancelDelivery(String id);
}
