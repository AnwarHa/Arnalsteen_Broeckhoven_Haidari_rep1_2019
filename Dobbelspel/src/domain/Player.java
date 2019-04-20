package domain;

import java.util.Random;

public class Player {

    private int playerNr, turn, playerScore, d1, d2, turnScore;

    public Player(int playerNr) {
        this.playerNr = playerNr;
        this.turn = 0;

    }

    // De speler gooit de dobbelstenen en de zowel de beurtscore als totale score wordt berekend
    public void calculateScore() {
        // Throw the dices
        this.d1 = new Random().nextInt(6);
        this.d2 = new Random().nextInt(6);

        // bereken score van de beurt zonder condities
        int score = d1 + d2;

        // met condities
        if (d1 == d2) {
            score *= 2;
        }

        if (this.turnScore == score) {
            playerScore += 5;
        }

        this.turnScore = score;

        // De beurt waarop de huidge speler zat en zijn totale score worden bijgewerkt
        this.turn += 1;
        this.playerScore += this.turnScore;


    }

    // Print de laatste beurt af van deze speler
    public String printLastTurn() {
        return "Turn " + this.turn + ", Player " + this.playerNr + " threw " + this.d1 + " & " + this.d2 + "- " + this.turnScore + " points";
    }

    // Getters

    public int getPlayerNr() {
        return playerNr;
    }

    public int getTurn() {
        return turn;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getD2() {
        return d2;
    }

    public int getD1() {
        return d1;
    }

    public int getTurnScore() {
        return turnScore;
    }

}
