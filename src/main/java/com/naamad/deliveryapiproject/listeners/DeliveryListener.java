package com.naamad.deliveryapiproject.listeners;

import com.naamad.deliveryapiproject.collection.Delivery;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DeliveryListener extends AbstractMongoEventListener<Delivery> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Delivery> event) {
        super.onBeforeConvert(event);
        LocalDate date = LocalDate.now();
        event.getSource().setCreatedAt(date.toString());
    }
}
