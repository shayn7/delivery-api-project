package com.naamad.deliveryapiproject.controller;

import com.naamad.deliveryapiproject.collection.Timeslot;
import com.naamad.deliveryapiproject.dto.FormattedAddress;
import com.naamad.deliveryapiproject.service.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/timeslot")
public class TimeslotController {

    private final TimeslotService timeslotService;

    @PostMapping("/timeslots")
    @ResponseStatus(HttpStatus.OK)
    public List<Timeslot> retrieveTimeslotsForAddress(@RequestBody FormattedAddress formattedAddress)  {
        return timeslotService.retrieveTimeslotsForAddress(formattedAddress);
    }
}
