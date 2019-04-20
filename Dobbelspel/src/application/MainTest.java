package application;

import domain.Game;
import domain.Player;
import view.ScoreView;

public class MainTest {

    public static void main(String[] args) {
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);

        Game game = new Game();

        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);

        game.throwDice();
        game.throwDice();
        System.out.println(game.currentPlayer().getPlayerNr());
        System.out.println(game.lastPlayer().getPlayerNr());





    }
}
