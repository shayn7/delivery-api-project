package com.naamad.deliveryapiproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naamad.deliveryapiproject.dto.AddressRequest;
import com.naamad.deliveryapiproject.dto.AddressResponse;
import com.naamad.deliveryapiproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/resolve-address")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse resolveAddress(@RequestBody AddressRequest addressRequest) throws JsonProcessingException {
        return addressService.resolveAddress(addressRequest);
    }
}
