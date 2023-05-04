package com.naamad.deliveryapiproject.collection;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Builder
@Document(collection = "timeslot")
public class Timeslot {

    @Id
    private String id;
    private String startTime;
    private String endTime;
    private List<String> supportedPostcodes;
}
