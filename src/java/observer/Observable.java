package java.observer;

public interface Observable {
    void attach(TriangleObserver observer);
    void detach(TriangleObserver observer);
    void notifyObservers();
}
