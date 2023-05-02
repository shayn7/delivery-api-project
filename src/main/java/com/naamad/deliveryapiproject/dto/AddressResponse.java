package com.naamad.deliveryapiproject.dto;

import lombok.Builder;

@Builder
public record AddressResponse(String line1,
                              String line2,
                              String street,
                              String city,
                              String county,
                              String postcode,
                              String country) {
}
