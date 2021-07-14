package dms.pastor.examples.patterns.observer;

public class GrabStocks {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver observer1 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(100.00);
        stockGrabber.setApplPrice(677.00);
        stockGrabber.setGoogPrice(676.00);
        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setIbmPrice(100.00);
        stockGrabber.setApplPrice(677.00);
        stockGrabber.setGoogPrice(676.00);

        stockGrabber.unregister(observer1);

        stockGrabber.setIbmPrice(100.00);
        stockGrabber.setApplPrice(677.00);
        stockGrabber.setGoogPrice(676.00);


    }
}
