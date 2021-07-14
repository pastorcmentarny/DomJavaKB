package dms.pastor.examples.patterns.observer;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObserver();
}
