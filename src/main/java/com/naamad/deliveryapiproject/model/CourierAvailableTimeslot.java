package com.naamad.deliveryapiproject.model;

import java.util.List;

public record CourierAvailableTimeslot(String start_time,
                                       String end_time,
                                       List<String> supported_postcodes) {
}
