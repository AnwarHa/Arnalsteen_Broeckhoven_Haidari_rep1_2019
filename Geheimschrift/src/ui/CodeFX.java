package ui;

import com.sun.org.apache.bcel.internal.classfile.Code;
import domain.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
        TextField textField = new TextField();

        // Coderen of decoderen
        Label keuzeB = new Label("Wil je coderen of decoderen");
        Button codeerB = new Button("Coderen");
        Button decodeerB = new Button("Decoderen");

        // Kies algo
        Label cb = new Label("Kies een algoritme: ");
        final ComboBox algos = new ComboBox();
        algos.getItems().addAll("Caesar", "Spiegeling", "Vigenère Cipher");
        algos.getSelectionModel().selectFirst();

        // Resultaat
        Label resultaat = new Label("-- resultaat --");

        // ENCODE
        codeerB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CodeerContext cc = checkAlgo(textField, algos);
                cc.encode();
                resultaat.setText(cc.getText());
            }
        });

        // DECODE
        decodeerB.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CodeerContext cc = checkAlgo(textField, algos);
                cc.decode();
                resultaat.setText(cc.getText());
            }
        });

        // Vbox
        VBox root = new VBox();
        root.getChildren().addAll(text, textField);
        root.getChildren().addAll(cb, algos);
        root.getChildren().addAll(keuzeB, codeerB, decodeerB);
        root.getChildren().addAll(resultaat);
        root.setSpacing(10);

        // Scene zetten
        Scene mainScene = new Scene(root, 500, 500);
        stage.setScene(mainScene);

        stage.show();
    }

    // CodeerContext teruggeven met juiste Strategy
    public CodeerContext checkAlgo(TextField textField, ComboBox algos) {
        CodeerContext cc = new CodeerContext(textField.getText());
        if (algos.getValue().equals("Caesar")) {
            cc.setCodeStrategy(new CaesarCipherStrategy());
        }
        if (algos.getValue().equals("Spiegeling")) {
            cc.setCodeStrategy(new MirrorStrategy());
        }
        if (algos.getValue().equals("Vigenère Cipher")) {
            cc.setCodeStrategy(new VigenèreCipherStrategy());
        }
        return cc;
    }
}
