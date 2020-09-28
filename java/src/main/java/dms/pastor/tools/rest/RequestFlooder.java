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

        for (int i = 0; i < 20; i++) {
            int counter = i;
            executorService.execute(() -> {
                long start = System.currentTimeMillis();
                try {
                    RestAssured.baseURI = urlAddress;
                    for (int i1 = 0; i1 < 1000; i1++) {
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("GET");
                        con.getResponseCode();
                    }
                    long stop = System.currentTimeMillis();
                    System.out.printf("No. %d .It took %d milliseconds%n", counter, (stop - start));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }
        System.out.println("Flooding complete.");
    }
}
