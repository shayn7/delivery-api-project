package com.naamad.deliveryapiproject.service_impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naamad.deliveryapiproject.dto.AddressRequest;
import com.naamad.deliveryapiproject.dto.AddressResponse;
import com.naamad.deliveryapiproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@PropertySource("external-rest-provider.properties")
@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    @Value("${api-key}")
    private String apiKey;

    @Override
    public AddressResponse resolveAddress(AddressRequest addressRequest) throws JsonProcessingException {
        String jsonResponse = getJsonResponseFromExternalApi(addressRequest);
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode propertiesNode = rootNode.get("features").get(0).get("properties");
        return buildAddressResponseObject(propertiesNode);
    }

    private AddressResponse buildAddressResponseObject(JsonNode propertiesNode) {
        return AddressResponse
                .builder()
                .line1(propertiesNode.get("address_line1").textValue())
                .line2(propertiesNode.get("address_line2").textValue())
                .street(propertiesNode.get("address_line1").textValue())
                .city(propertiesNode.get("city").textValue())
                .postcode(propertiesNode.get("postcode").textValue())
                .county(propertiesNode.get("county").textValue())
                .country(propertiesNode.get("country").textValue())
                .build();
    }

    private String getJsonResponseFromExternalApi(AddressRequest addressRequest) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                .queryParam("text", addressRequest.searchTerm())
                .queryParam("apiKey", apiKey)
                .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
