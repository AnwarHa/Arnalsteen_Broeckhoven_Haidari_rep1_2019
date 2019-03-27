package application;
	
import domain.GameObservable;
import domain.Observable;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		GameObservable game = new GameObservable();
		PlayerView pv3 = new PlayerView(3,game);
		PlayerView pv2 = new PlayerView(2,game);
		PlayerView pv1 = new PlayerView(1,game);
		new ScoreView(game);
		pv1.isAanBeurt(true);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
