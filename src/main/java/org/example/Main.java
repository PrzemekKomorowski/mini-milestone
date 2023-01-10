package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Airline airline = new Airline();

        //Tworzymy loty
        Flight flight1 = new Flight("LH1234", "English");
        Flight flight2 = new Flight("LH5678", "German");
        airline.addFlight(flight1);
        airline.addFlight(flight2);

        // Tworzymy pracowników
        Pilot captain1 = new Pilot("John", "Wick", LocalDate.of(1980, 1, 1), "Captain");
        captain1.giveCompass();
        Pilot coPilot1 = new Pilot("Michael", "Jackson", LocalDate.of(1985, 2, 2), "Co-pilot");
        coPilot1.giveCompass();
        Set<String> stewardessLanguages = new HashSet<>(Arrays.asList("English", "German"));
        Stewardess stewardess1 = new Stewardess("Sylwia", "Hetman", LocalDate.of(1990, 3, 3), stewardessLanguages);
        airline.addEmployee(captain1);
        airline.addEmployee(coPilot1);
        airline.addEmployee(stewardess1);

        // Przypisujemy pracowników do lotów
        airline.assignEmployeeToFlight(captain1.getFullName(), flight1.getFlightNumber());
        airline.assignEmployeeToFlight(coPilot1.getFullName(), flight1.getFlightNumber());
        airline.assignEmployeeToFlight(stewardess1.getFullName(), flight1.getFlightNumber());








        // Sprawdzanie odprawy lotu
        if (flight1.isReadyForDeparture()) {
            System.out.println("Flight is ready for departure");
        } else {
            System.out.println("Flight is not ready for departure");
            for (String step : flight1.getCheckSteps()) {
                System.out.println(step);
            }
        }
    }
}