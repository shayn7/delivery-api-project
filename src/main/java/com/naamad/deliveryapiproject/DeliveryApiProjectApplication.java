package com.naamad.deliveryapiproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naamad.deliveryapiproject.model.CourierAvailableTimeslot;
import com.naamad.deliveryapiproject.model.Holiday;
import com.naamad.deliveryapiproject.model.RootCourierAvailableTimeslot;
import com.naamad.deliveryapiproject.model.RootHoliday;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@SpringBootApplication
public class DeliveryApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiProjectApplication.class, args);
	}

}
