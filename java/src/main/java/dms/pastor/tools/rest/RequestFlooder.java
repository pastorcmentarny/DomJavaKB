package dms.pastor.tools.rest;

import io.restassured.RestAssured;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * it requires a revenger project to be running
 */
public class RequestFlooder {

    public static void main(String[] args) throws Exception {
        String urlAddress = "http://localhost:5000/promotions";
        URL url = new URL(urlAddress);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int interationCounter = 0; interationCounter < 20; interationCounter++) {
            int counter = interationCounter;
            executorService.execute(() -> {
                long start = System.currentTimeMillis();
                try {
                    RestAssured.baseURI = urlAddress;
                    for (int index = 0; index < 1000; index++) {
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("GET");
                        con.getResponseCode();
                    }
                    long stop = System.currentTimeMillis();
                    System.out.printf("No. %d .It took %d milliseconds%n", counter, (stop - start));
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            });
        }
        System.out.println("Flooding complete.");
    }
}
