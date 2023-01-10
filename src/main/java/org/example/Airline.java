package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airline {
    private List<Flight> flights;
    private Map<String, Employee> employees;

    public Airline() {
        flights = new ArrayList<>();
        employees = new HashMap<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addEmployee(Employee employee) {
        employees.put(employee.getFullName(), employee);
    }

    public Employee getEmployee(String fullName) {
        return employees.get(fullName);
    }

    public boolean assignEmployeeToFlight(String employeeFullName, String flightNumber) {
        Employee employee = getEmployee(employeeFullName);
        if (employee == null) {
            System.out.println("Employee not found");
            return false;
        }

        Flight flight = null;
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                flight = f;
                break;
            }
        }

        if (flight == null) {
            System.out.println("Flight not found");
            return false;
        }

        flight.registerEmployee(employee);
        return true;
    }
}

