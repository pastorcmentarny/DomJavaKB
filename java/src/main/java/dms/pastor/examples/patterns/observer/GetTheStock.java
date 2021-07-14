package dms.pastor.examples.patterns.observer;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable{
    private int startTime;
    private String stock;
    private double price;
    private Subject stockGrabber;

    public GetTheStock(int startTime, String stock, double price, Subject stockGrabber) {
        this.stockGrabber = stockGrabber;

        this.startTime = startTime;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public void run() {
        for(int i=1; i< 20; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                System.out.println(interruptedException.getMessage());
            }
            double randNum = (Math.random() * (.06)) - .03; // this the way to get random number between -+ .03
            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.parseDouble(df.format(price + randNum));

            if (stock.equals("IBM")){
                ((StockGrabber)stockGrabber).setIbmPrice(price);
            }

            if (stock.equals("AAPL")){
                ((StockGrabber)stockGrabber).setApplPrice(price);
            }

            if (stock.equals("GOOG")){
                ((StockGrabber)stockGrabber).setGoogPrice(price);
            }

            System.out.println(stock + ": " + df.format((price + randNum)) + " " + df.format(randNum));
            System.out.println();
        }
    }
}
