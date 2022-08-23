package com.sparta.jn.apitesting.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ChuckNorrisPojo chuckNorrisPojo = mapper.readValue(new URL("https://api.chucknorris.io/jokes/random"),
                    ChuckNorrisPojo.class);
            RatesPojo ratesPojo = mapper.readValue(new File("src/test/resources/rates.json"),
                    RatesPojo.class);

//            JsonNode jsonNode = mapper.readTree(new URL(""));
//            System.out.println(jsonNode
//                    .get());
            System.out.println(Arrays.toString(chuckNorrisPojo.getClass().getDeclaredFields()));
            System.out.println(chuckNorrisPojo.toString());
            System.out.println(chuckNorrisPojo.getIconUrl().contains("http"));
//            System.out.println("Hello".matches()); regex

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
