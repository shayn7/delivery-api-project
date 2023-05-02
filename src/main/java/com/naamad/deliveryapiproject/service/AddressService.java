package com.naamad.deliveryapiproject.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.naamad.deliveryapiproject.dto.AddressRequest;
import com.naamad.deliveryapiproject.dto.AddressResponse;

public interface AddressService {

    AddressResponse resolveAddress(AddressRequest addressRequest) throws JsonProcessingException;
}
