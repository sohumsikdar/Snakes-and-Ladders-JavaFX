package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditScene {

    @FXML
    private ImageView backButton;

    @FXML
    void backToMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("startScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void mouseOffBack(MouseEvent event) {
        backButton.setLayoutX(13);
        backButton.setLayoutY(14);
        backButton.setFitHeight(50);
        backButton.setFitWidth(80);
    }

    @FXML
    void mouseOnBack(MouseEvent event) {
        backButton.setLayoutX(11.7);
        backButton.setLayoutY(12.6);
        backButton.setFitWidth(88);
        backButton.setFitHeight(55);
    }

}
