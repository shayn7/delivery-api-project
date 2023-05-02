package com.naamad.deliveryapiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
    private String line1;
    private String line2;
    private String street;
    private String city;
    private String county;
    private String postcode;
    private String country;
}
