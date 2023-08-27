package org.example;

//import org.example.database.GsonParser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Move {

    private List<String> cities;
    private HashSet<String> usedCities;
    private String lastCity;
    private Scanner scanner;
    String input = "";

    public Move() {
        cities = new ArrayList<String>();
        usedCities = new HashSet<String>();
        scanner = new Scanner(System.in);
      //  GsonParser gsonParser = new GsonParser();
    }

    // private void loadCities() {
    //        // Завантажте міста з файлу або іншого джерела тут
    //        // cities.add("місто1");
    //        // cities.add("місто2");
    //        // ...
    //    }


    public String playGame(String city) {

        System.out.println("Welcome to the Cities Game!");

        try {

            while (true) {
                // Хід гравця
                System.out.println("Enter a city: ");
                String playerCity = scanner.nextLine().trim();

                if (!usedCities.contains(city) && city.startsWith(lastCity.substring(lastCity.length() - 1).toUpperCase())) {
                    System.out.println("Invalid city or repeated city. Try again.");
                    continue;
                }
                usedCities.add(playerCity);
                lastCity =playerCity;

                // Хід комп'ютера

                String computerResponse = getComputerMove();

                // Вивід відповіді комп'ютера
                System.out.println("Computer: " + computerResponse);
                lastCity = computerResponse;


            }
        } finally {
            scanner.close();
        }

    }

    public String getComputerMove() {


        String nextCity = "";

        for (String city : cities) {
            if (!usedCities.contains(city) && city.startsWith(lastCity.substring(lastCity.length() - 1).toUpperCase())) {
                nextCity = city;
                break;
            }

        }
        if (nextCity.isEmpty()) {
            return "Congratulations! You won! The computer can't find the next move.";
        }
        lastCity = nextCity;
        usedCities.add(nextCity);
        return nextCity;

    }
}
