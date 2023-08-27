package org.example;

import org.example.database.GsonParser;

public class Main {
    public static void main(String[] args) {
        GsonParser gsonParser = new GsonParser();
        System.out.println(gsonParser.getCityNames());
    }
}
