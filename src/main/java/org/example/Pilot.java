package org.example;

import java.time.LocalDate;

public class Pilot extends Employee {
    private String rank;
    private Boolean compass;

    public Pilot(String firstName, String lastName, LocalDate dateOfBirth, String rank) {
        super(firstName, lastName, dateOfBirth);
        this.rank = rank;
    }

    public String getRank(){
        return rank;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    public boolean hasCompass(){
        return compass;
    }

    public void giveCompass(){
        this.compass = true;
    }



}
