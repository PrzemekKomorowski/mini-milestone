package org.example;

import java.time.LocalDate;
import java.util.Set;



public class Stewardess extends Employee {

    private Set<String> languages;
    public Stewardess(String firstName, String lastName, LocalDate dateOfBirth, Set<String> languages) {
        super(firstName, lastName, dateOfBirth);
        this.languages = languages;
    }


    public Set<String> getLanguages(){
        return languages;
    }

    public void setLanguages(Set<String> languages){
        this.languages = languages;
    }


}
