package org.example;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightNumber;
    private String flightLanguage;
    private List<Employee> employees;
    private List<String> checkSteps;

    public Flight(String flightNumber, String flightLanguage) {
        this.flightNumber = flightNumber;
        this.flightLanguage = flightLanguage;
        this.employees = new ArrayList<>();
        this.checkSteps = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFlightLanguage() {
        return flightLanguage;
    }

    public boolean isReadyForDeparture() {
        boolean isCaptainAndCoPilotReady = false;
        boolean isStewardessesReady = true;
        for (Employee employee : employees) {
            if (employee instanceof Pilot) {
                Pilot pilot = (Pilot) employee;
                if (pilot.getRank().equals("Captain")) {
                    if (pilot.hasCompass()) {
                        isCaptainAndCoPilotReady = true;
                    } else {
                        checkSteps.add("Check failed: Captain does not have compass");
                        return false;
                    }
                } else if (pilot.getRank().equals("Co-pilot")) {
                    if (pilot.hasCompass()) {
                        isCaptainAndCoPilotReady = true;
                    } else {
                        checkSteps.add("Check failed: Co-pilot does not have compass");
                        return false;
                    }
                }
            } else if (employee instanceof Stewardess) {
                Stewardess stewardess = (Stewardess) employee;
                if (!stewardess.getLanguages().contains(flightLanguage)) {
                    isStewardessesReady = false;
                    checkSteps.add("Check failed: Stewardess " + stewardess.getFullName() + " does not speak flight language");
                }
            }
        }
        if (!isCaptainAndCoPilotReady) {
            checkSteps.add("Check failed: Captain and Co-pilot are not ready");
            return false;
        } else if (!isStewardessesReady) {
            checkSteps.add("Check failed: Stewardesses are not ready");
            return false;
        } else {
            checkSteps.add("Check successful");
            return true;
        }
    }

    public void registerCheckStep(String step) {
        checkSteps.add(step);
    }

    public void registerEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<String> getCheckSteps() {
        return checkSteps;
    }
}
