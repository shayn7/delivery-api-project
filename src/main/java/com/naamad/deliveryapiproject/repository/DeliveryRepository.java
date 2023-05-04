package com.naamad.deliveryapiproject.repository;

import com.naamad.deliveryapiproject.collection.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, String> {
}
