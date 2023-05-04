package com.naamad.deliveryapiproject.collection;

import com.naamad.deliveryapiproject.enums.DeliveryStatus;
import com.naamad.deliveryapiproject.model.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Builder
@Data
@Document(collection = "delivery")
public class Delivery {

    @Id
    private String id;
    @Field(targetType = FieldType.STRING)
    private DeliveryStatus deliveryStatus;
    @DBRef
    private Timeslot timeslot;
    private User user;
}
