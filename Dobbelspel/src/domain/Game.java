package domain;

import java.util.*;

public class Game {
    private ScoreBoard player1;
    private ScoreBoard player2;
    private ScoreBoard player3;
    private int turns 4;
    private ArrayList orderTurns;

    public Game() {

    }

    public int throwDice(){
       return new Random(6).nextInt();
    }
}
