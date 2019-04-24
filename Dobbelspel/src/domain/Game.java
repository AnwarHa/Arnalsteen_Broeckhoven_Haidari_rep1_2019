package domain;

import view.PlayerView;
import view.ScoreView;

public class Game implements Subject {

    private Player[] players;
    private Observer[] observers;
    private Observer scoreView;
    private String text = "";
    private int turnCount, numberOfTurns;

    public Game() {
        players = new Player[3];
        observers = new PlayerView[3];
        scoreView = new ScoreView();
    }

    // Geeft de speler terug die aan de beurt moet zijn
    public Player currentPlayer() {
        int minTurn = players[0].getTurn();
        int minPlayer = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getTurn() < minTurn) {
                minTurn = players[i].getTurn();
                minPlayer = i;
            }
        }
        return players[minPlayer];
    }

    // Geeft de speler terug die het laatst aan de beurt was
    public Player lastPlayer() {
        int maxTurn = players[0].getTurn();
        int maxPlayer = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getTurn() >= maxTurn) {
                maxTurn = players[i].getTurn();
                maxPlayer = i;
            }
        }
        return players[maxPlayer];
    }

    // Voegt speler toe
    public void addPlayer(Player p) {
        if (p != null) {
            players[p.getPlayerNr() - 1] = p;
        }
    }

    // De speler die aan de beurt is gooit de dobbelstenen (waardoor hij niet meer aan de beurt is)
    public void throwDice() {
        currentPlayer().calculateScore();
        turnCount++;
        this.text = lastPlayer().printLastTurn();
        if (turnCount == players.length) {
            this.text += "\n" + turnWinner();
            turnCount = 0;
            numberOfTurns++;
            if (numberOfTurns == 4) {
                this.text += "\n" + gameWinner();
            }
        }
        notifyObservers();
    }

    // Winnaar van een beurt
    public String turnWinner() {
        int winner = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getTurnScore() > players[winner].getTurnScore()) {
                winner = i;
            }
        }

        Player player = players[winner];
        return "--- Player " + player.getPlayerNr() + " won round " + player.getTurn() + " with " + player.getTurnScore() + " points ! ---";
    }

    // Winnaar van het spel
    public String gameWinner() {
        int winner = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPlayerScore() > players[winner].getPlayerScore()) {
                winner = i;
            }
        }
        Player player = players[winner];
        return "Congratulations Player " + player.getPlayerNr() + " ! " + "\n" + "You won the game with " + player.getPlayerScore() + " points :D";
    }

    // Getters
    public Player[] getPlayers() {
        return players;
    }


    public Observer[] getObservers() {
        return observers;
    }

    public Observer getScoreView() {
        return scoreView;
    }

    public String getText() {
        return text;
    }

    // Subject methods
    @Override
    public void register(Observer o) {
        if (o != null && o instanceof PlayerView) {
            observers[((PlayerView) o).getSpelerNummer() - 1] = o;

        }

    }

    @Override
    public void remove(Observer o) {
        if (o != null && o instanceof PlayerView) {
            observers[((PlayerView) o).getSpelerNummer() - 1] = null;
        }

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.length; i++) {
            observers[i].update(this.text);
        }
        scoreView.update(this.text);
    }
}


