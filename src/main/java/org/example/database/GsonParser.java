package org.example.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonParser {
    private List<String> cityNames;


    public List<String> getCityNames(){
        return parseJsonFromFile();
    }


    private List<String> parseJsonFromFile() {
        Gson gson = new Gson();
        cityNames = new ArrayList<>();

        try (FileReader reader = new FileReader("ua.json")) {
            Type type = new TypeToken<ArrayList<City>>() {
            }.getType();
            List<City> cities = gson.fromJson(reader, type);

            for (City city : cities) {
                cityNames.add(city.getCity());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cityNames;
    }
}
