package com.naamad.deliveryapiproject.controller;

import com.naamad.deliveryapiproject.collection.Delivery;
import com.naamad.deliveryapiproject.dto.DeliveryRequest;
import com.naamad.deliveryapiproject.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/deliveries")
    @ResponseStatus(HttpStatus.CREATED)
    public String bookDelivery(@RequestBody DeliveryRequest deliveryRequest) {
         return deliveryService.bookDelivery(deliveryRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelDelivery(@PathVariable String id) {
        deliveryService.cancelDelivery(id);
    }

    @GetMapping("deliveries/today")
    @ResponseStatus(HttpStatus.OK)
    public List<Delivery> getAllDeliveriesForToday(){
        return deliveryService.getAllDeliveriesForToday();
    }
}
