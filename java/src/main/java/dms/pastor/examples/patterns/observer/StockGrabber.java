package dms.pastor.examples.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber  implements Subject{
    private List<Observer> observerList;
    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    public StockGrabber(){
        observerList = new ArrayList<Observer>();
    }
    @Override
    public void register(Observer newObserver) {
        observerList.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observerList.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex+1) + " deleted");
        observerList.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observerList) {
            observer.update(ibmPrice,applPrice,googPrice);
        }
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setApplPrice(double applPrice) {
        this.applPrice = applPrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
}
