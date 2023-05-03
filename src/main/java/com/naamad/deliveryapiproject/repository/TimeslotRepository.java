package com.naamad.deliveryapiproject.repository;

import com.naamad.deliveryapiproject.collection.Timeslot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeslotRepository extends MongoRepository<Timeslot, String> {
}
