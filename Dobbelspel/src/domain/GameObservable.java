package domain;

import java.util.Observable;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameObservable extends Observable {
    private ScoreBoard player1;
    private ScoreBoard player2;
    private ScoreBoard player3;
    private int turns = 4;
    private ArrayList<ScoreBoard> players;
    private int currentPlayer;
    private int currentRound=1;

    public GameObservable() {
        players = new ArrayList();
        player1 = new ScoreBoard();
        player2 = new ScoreBoard();
        player3 = new ScoreBoard();
        players.add(player1);
        players.add(player2);
        players.add(player3);
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
        players.get(this.getCurrentPlayer()-1).setScore(ThreadLocalRandom.current().nextInt(2, 12 + 1));
    }



}
