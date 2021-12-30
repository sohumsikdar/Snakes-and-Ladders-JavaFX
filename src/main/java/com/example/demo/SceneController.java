package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    @FXML
    private ImageView credits;

    @FXML
    private ImageView exit;

    @FXML
    private ImageView multi;

    @FXML
    private ImageView rules;

    @FXML
    private ImageView single;

    @FXML
    void exitApp(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void mouseOffCredits(MouseEvent event) {
        credits.setLayoutY(624);
        credits.setLayoutX(160);
        credits.setFitHeight(43);
        credits.setFitWidth(128);
    }

    @FXML
    void mouseOffExit(MouseEvent event) {
        exit.setLayoutX(190);
        exit.setLayoutY(683);
        exit.setFitHeight(43);
        exit.setFitWidth(77);
    }

    @FXML
    void mouseOffMulti(MouseEvent event) {
        multi.setLayoutY(428);
        multi.setLayoutX(128);
        multi.setFitHeight(48);
        multi.setFitWidth(200);
    }

    @FXML
    void mouseOffRules(MouseEvent event) {
        rules.setLayoutY(562);
        rules.setLayoutX(171);
        rules.setFitHeight(43);
        rules.setFitWidth(114);
    }

    @FXML
    void mouseOffSingle(MouseEvent event) {
        single.setLayoutY(491);
        single.setLayoutX(128);
        single.setFitHeight(50);
        single.setFitWidth(200);
    }

    @FXML
    void mouseOnCredits(MouseEvent event) {
        credits.setLayoutY(620);
        credits.setLayoutX(156);
        credits.setFitHeight(47.3);
        credits.setFitWidth(140.8);
    }

    @FXML
    void mouseOnExit(MouseEvent event) {
        exit.setLayoutX(186);
        exit.setLayoutY(679);
        exit.setFitHeight(47.4);
        exit.setFitWidth(84.7);
    }

    @FXML
    void mouseOnMulti(MouseEvent event) {
        multi.setLayoutY(424);
        multi.setLayoutX(124);
        multi.setFitHeight(52.8);
        multi.setFitWidth(220);
    }

    @FXML
    void mouseOnRules(MouseEvent event) {
        rules.setLayoutY(557);
        rules.setLayoutX(168);
        rules.setFitHeight(47.3);
        rules.setFitWidth(125.4);

    }

    @FXML
    void mouseOnSingle(MouseEvent event) {
        single.setLayoutY(487);
        single.setLayoutX(124);
        single.setFitHeight(55);
        single.setFitWidth(220);
    }

    @FXML
    void showCredits(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Credits_screen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void showRules(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Rules_page.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToMultiplayer(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gameScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Main.startNewGame(false);
        Main.pc = (playerController) loader.getController();
    }

    @FXML
    void switchToSingle(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gameScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Main.startNewGame(true);
        Main.pc = (playerController) loader.getController();
    }
}
