package pattern.ehu.task1.observer;

public interface Observable {
    void attach();

    void detach();

    void notifyObservers();
}
