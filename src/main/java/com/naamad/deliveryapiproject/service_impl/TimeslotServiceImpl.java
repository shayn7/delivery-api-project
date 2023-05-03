package com.naamad.deliveryapiproject.service_impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naamad.deliveryapiproject.collection.Timeslot;
import com.naamad.deliveryapiproject.dto.FormattedAddress;
import com.naamad.deliveryapiproject.model.CourierAvailableTimeslot;
import com.naamad.deliveryapiproject.model.Holiday;
import com.naamad.deliveryapiproject.model.RootCourierAvailableTimeslot;
import com.naamad.deliveryapiproject.model.RootHoliday;
import com.naamad.deliveryapiproject.repository.TimeslotRepository;
import com.naamad.deliveryapiproject.service.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.text.Format;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TimeslotServiceImpl implements TimeslotService, CommandLineRunner {

    private final TimeslotRepository timeslotRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<Timeslot> retrieveTimeslotsForAddress(FormattedAddress formattedAddress) {
        String postcode = formattedAddress.postcode();
        List<Timeslot> timeslots = timeslotRepository.findAll();
        return timeslots.stream().filter(e -> e.getSupportedPostcodes().contains(postcode)).toList();
    }

    @Override
    public void run(String... args) throws Exception {
        RootHoliday rootHoliday = objectMapper.readValue(Paths.get("src/main/resources/static/holidays.json").toFile(), RootHoliday.class);
        RootCourierAvailableTimeslot rootCourierAvailableTimeslot = objectMapper.readValue(Paths.get("src/main/resources/static/timeslots.json").toFile(), RootCourierAvailableTimeslot.class);
        Set<String> holidayDates = rootHoliday.holidays().stream().map(Holiday::date).collect(Collectors.toSet());
        List<CourierAvailableTimeslot> availableSlots = rootCourierAvailableTimeslot.courier_available_timeslots().stream()
                .filter(courierAvailableTimeslot -> !holidayDates.contains(courierAvailableTimeslot.start_time().split(" ")[0])).toList();
        availableSlots.forEach(System.out::println);
        if(timeslotRepository.findAll().isEmpty()) timeslotRepository.saveAll(availableSlots.stream().map(this::mapToTimeslot).collect(Collectors.toList()));
    }

    private Timeslot mapToTimeslot(CourierAvailableTimeslot timeslot) {
        return Timeslot
                .builder()
                .startTime(timeslot.start_time())
                .endTime(timeslot.end_time())
                .supportedPostcodes(timeslot.supported_postcodes())
                .build();
    }

}
