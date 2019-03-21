package domain;

import java.util.*;

public class Game {


    public Game() {

    }

    public int throwDice(){
       return new Random(6).nextInt();
    }
}
