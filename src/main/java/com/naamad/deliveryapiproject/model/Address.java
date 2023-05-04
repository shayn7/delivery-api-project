package com.naamad.deliveryapiproject.model;

public record Address(String line1,
                      String line2,
                      String street,
                      String city,
                      String county,
                      String postcode,
                      String country) {
}
