package StepProjectBooking.generator;

import StepProjectBooking.Cities;
import StepProjectBooking.classes.Flight;
import StepProjectBooking.controller.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class FlightRandomGenerator {
    static final Controller controller;
    static {
        controller = new Controller();
    }

    public static void generateRandomFlights() {
        List<Flight> flights = new ArrayList<>();
        int n = controller.lastFlightsId();
        for (int i = n; i < n+20;i++) {
            Flight flight = new Flight();
            flight.setId(i);
            flight.setDestination(Cities.getRandomCity());
            flight.setFreeSeats((new Random().nextInt(20)+20));
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
            LocalDateTime localDateTime = LocalDateTime.now().
                    plusHours(new Random().nextInt(23)).withMinute((new Random().nextInt(4)+1)*10);
            flight.setTime(localDateTime.format(dateTimeFormatter));
            flights.add(flight);
        }
        controller.writeFlights(flights);
    }


}
