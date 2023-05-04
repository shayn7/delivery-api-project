package com.naamad.deliveryapiproject.service;

import com.naamad.deliveryapiproject.collection.Delivery;
import com.naamad.deliveryapiproject.dto.DeliveryRequest;

import java.util.List;

public interface DeliveryService {
    String bookDelivery(DeliveryRequest deliveryRequest);

    void cancelDelivery(String id);

    List<Delivery> getAllDeliveriesForToday();
}
