package ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CodeFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Primarystage) {
        Stage stage = new Stage();

        stage.setTitle("Java Geheimschrift");


        // Tekst ingeven
        Label text = new Label("Geef tekst in:");
        TextField textField = new TextField ();

        // Keuze algoritme
        Label resultaat = new Label("Resultaat:");
        TextField res = new TextField ();
        Button send = new Button("Verzenden");

        Label cb = new Label("Kies een algoritme: ");
        final ComboBox algos = new ComboBox();
        algos.getItems().addAll("Caesar", "Spiegeling", "Vigenère Cipher");

        // Coderen of decoderen
        Label keuzeB = new Label("Wil je coderen of decoderen");
        Button codeerB = new Button("Coderen");
        Button decodeerB = new Button("Decoderen");
        codeerB.setOnAction(new CheckResultHandler());
        decodeerB.setOnAction(new CheckResultHandler());

        // Vbox
        VBox root = new VBox();
        root.getChildren().addAll(text, textField, send);
        root.getChildren().addAll(keuzeB, codeerB, decodeerB);
        root.getChildren().addAll(cb, algos);
        root.getChildren().addAll(resultaat, res);
        root.setSpacing(10);

        // Scene zetten
        Scene mainScene = new Scene(root, 500, 500);
        stage.setScene(mainScene);


        stage.show();

    }
}
