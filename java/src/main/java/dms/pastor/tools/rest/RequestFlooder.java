package dms.pastor.tools.rest;

import io.restassured.RestAssured;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestFlooder {
    private static String urlAddress = "http://voucher-promotion-service.service.eu-west-1.dev.deveng.systems/promotions";

    public static void main(String[] args) throws Exception {
        URL url = new URL(urlAddress);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long start = System.currentTimeMillis();
                    try {
                        RestAssured.baseURI = "http://voucher-promotion-service.service.eu-west-1.dev.deveng.systems/promotions";
                        for (int i = 0; i < 1000; i++) {
                            HttpURLConnection con = (HttpURLConnection) url.openConnection();
                            con.setRequestMethod("GET");
                            con.getResponseCode();
                        }
                        long stop = System.currentTimeMillis();
                        System.out.println("it took " + (stop - start) + " milliseconds");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
    }
}



/*
        RestAssured.baseURI = "http://voucher-promotion-service.service.eu-west-1.dev.deveng.systems/promotions";
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // send 1st 7 requests here
        for (int i = 0; i < 20; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run(){
                    long start = System.currentTimeMillis();
                    try {
                        RestAssured.baseURI = "http://voucher-promotion-service.service.eu-west-1.dev.deveng.systems/promotions";
                        for (int i = 0; i < 1000; i++) {
                            RestAssured.get();
                        }
                        long stop = System.currentTimeMillis();
                        System.out.println("it took " + (stop - start) + " milliseconds");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }
 */