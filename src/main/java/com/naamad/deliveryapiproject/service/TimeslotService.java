package com.naamad.deliveryapiproject.service;

import com.naamad.deliveryapiproject.collection.Timeslot;
import com.naamad.deliveryapiproject.dto.FormattedAddress;

import java.util.List;

public interface TimeslotService {
    List<Timeslot> retrieveTimeslotsForAddress(FormattedAddress formattedAddress);
}
