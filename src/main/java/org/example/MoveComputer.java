package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class MoveComputer {

    private ArrayList<String> cities;
    private HashSet<String> usedCities;
    private String lastCity;
    String input = "";
    public String getComputerMove(String input) {


        String nextCity = "";
        cities = new ArrayList<String>();
        usedCities = new HashSet<String>();

        for (String city : cities
        ) {
            if (!usedCities.contains(city) && city.startsWith(input.substring(input.length() - 1).toUpperCase())) {
                nextCity = city;
                break;
            }

        }
        if (nextCity.isEmpty()) {
            return "Congratulations! You won! The computer can't find the next move.";
        }
        lastCity = nextCity;
        usedCities.add(nextCity);
        return  nextCity;

    }
}
