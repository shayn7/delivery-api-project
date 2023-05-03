package com.naamad.deliveryapiproject.dto;

public record FormattedAddress(String line1,
                               String line2,
                               String street,
                               String city,
                               String county,
                               String postcode,
                               String country) {
}
