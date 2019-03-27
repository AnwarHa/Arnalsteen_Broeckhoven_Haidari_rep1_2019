package domain;

import view.PlayerView;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameObservable implements Observable {
    private ScoreBoard scoreBoard = new ScoreBoard();
    private int turns = 4;
    private int currentPlayer;
    private int currentRound=1;
    public List<Observer> playersOrder;
    private Map<Observer,ScoreBoard> observers;

    public GameObservable() {
        observers = new HashMap<>();
    }

    public void nextRound(){
        currentRound++;
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public int getNextPlayer(){
        return currentPlayer++;
    }

    public void throwDice(){
        observers.get(this.getCurrentPlayer()-1).setScore(ThreadLocalRandom.current().nextInt(2, 12 + 1));
    }
    @Override
    public void add(Observer observer) {
        if(observer!=null){
            observers.put(observer,new ScoreBoard());
        }
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public String getState(Observer observer) {
        return observers.get(observer).getScore()+"";
    }
}
