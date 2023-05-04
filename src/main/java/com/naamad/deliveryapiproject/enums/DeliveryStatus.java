package com.naamad.deliveryapiproject.enums;

import lombok.Getter;

@Getter
public enum DeliveryStatus {
    BOOKED("booked"),
    DELIVERED("delivered");

    private final String status;

    DeliveryStatus(String status) {
        this.status = status;
    }
}
