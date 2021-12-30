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

public class RulesPage {

    @FXML
    private ImageView back;

    @FXML
    void goToMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("startScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void mouseOffBack(MouseEvent event) {
        back.setLayoutX(13);
        back.setLayoutY(14);
        back.setFitHeight(50);
        back.setFitWidth(80);
    }

    @FXML
    void mouseOnBack(MouseEvent event) {
        back.setLayoutX(11.7);
        back.setLayoutY(12.6);
        back.setFitWidth(88);
        back.setFitHeight(55);
    }
}
