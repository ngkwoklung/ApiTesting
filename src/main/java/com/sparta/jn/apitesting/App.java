package com.sparta.jn.apitesting;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App 
{
    public static void main( String[] args )
            //HttpRequest, HttpClient, HttpResponse
    {
        HttpClient client = HttpClient.newHttpClient(); //can use var

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
