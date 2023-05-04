package com.naamad.deliveryapiproject.service_impl;

import com.naamad.deliveryapiproject.collection.Delivery;
import com.naamad.deliveryapiproject.collection.Timeslot;
import com.naamad.deliveryapiproject.dto.DeliveryRequest;
import com.naamad.deliveryapiproject.enums.DeliveryStatus;
import com.naamad.deliveryapiproject.model.User;
import com.naamad.deliveryapiproject.repository.DeliveryRepository;
import com.naamad.deliveryapiproject.repository.TimeslotRepository;
import com.naamad.deliveryapiproject.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService, CommandLineRunner {

    private final DeliveryRepository deliveryRepository;
    private final TimeslotRepository timeslotRepository;
    private final Map<String, User> map = new HashMap<>();

    @Override
    public String bookDelivery(DeliveryRequest deliveryRequest) {
        Optional<Timeslot> timeslot = timeslotRepository.findById(deliveryRequest.timeslotId());
        timeslot.orElseThrow(() -> new RuntimeException("timeslot not exists"));
        if (!map.containsKey(deliveryRequest.userId())) throw new RuntimeException("user does not exists");
        Delivery delivery = mapToDelivery(timeslot.get(), map.get(deliveryRequest.userId()));
        return deliveryRepository.save(delivery).getId();
    }

    @Override
    public void cancelDelivery(String id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if(delivery.isEmpty()) throw new RuntimeException("delivery not found");
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> getAllDeliveriesForToday() {
        return deliveryRepository.findAll().stream().filter(e->e.getCreatedAt().equals(LocalDate.now().toString())).collect(Collectors.toList());
    }

    private Delivery mapToDelivery(Timeslot timeslot, User user) {
        return Delivery
                .builder()
                .user(user)
                .deliveryStatus(DeliveryStatus.BOOKED)
                .timeslot(timeslot)
                .build();
    }

    @Override
    public void run(String... args) {
        User shay = new User("1", "shay", "shay@gmail.com");
        User roni = new User("2", "roni", "roni@gmail.com");
        map.put(shay.id(), shay);
        map.put(roni.id(), roni);
    }
}
