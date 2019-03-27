package domain;

public interface Observable {
    void add(Observer observer);
    void remove (Observer observer);
    String getState(Observer observer);
}
