package com.example.demo;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class playerController {
    private int DiceValue;

    @FXML
    ImageView testDice;

    @FXML
    ImageView blue;

    @FXML
    ImageView green;

    @FXML
    ImageView backButton;

    @FXML
    ImageView arrow;

    @FXML
    ImageView warning;

    @FXML
    ImageView yes;

    @FXML
    ImageView no;

    @FXML
    ImageView blueWin;

    @FXML
    ImageView greenWin;

    @FXML
    ImageView player1;

    @FXML
    ImageView player2;

    @FXML
    ImageView bot;

    private ImageView tok;
    boolean complete;


    public void moves(player p) throws InterruptedException {
        if (p.getCol().equals("blue")) {
            tok = blue;
        } else {
            tok = green;
        }

        if (!p.isOpen() && DiceValue != 1) {
            return;
        }

        if (p.getPos() + DiceValue > 100) return;
        p.setOpen();
        int currentPosition = p.getPos();
        p.setPos(DiceValue);
        this.complete = false;

        SequentialTransition st = new SequentialTransition();
        for (int i = currentPosition + 1; i <= p.getPos(); i++) {
            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.25), tok);

            int xc = Game.Board.get(i - 1).get(0);
            int yc = Game.Board.get(i - 1).get(1);

            int x0 = Game.Board.get(i).get(0);
            int y0 = Game.Board.get(i).get(1);


            translate.setByX(x0 - xc);
            translate.setByY(y0 - yc);
            st.getChildren().add(translate);
        }


        System.out.println("player at " + p.getPos());
        if (Game.Ladders.containsKey(p.getPos())) {
            ladder ld = Game.Ladders.get(p.getPos());
            int newPos = ld.end;
            System.out.println("Ladder ends at " + newPos);

            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.25), tok);

            int xc = Game.Board.get(p.getPos()).get(0);
            int yc = Game.Board.get(p.getPos()).get(1);
            p.setPosSnakeOrLadder(newPos);
            int x0 = Game.Board.get(newPos).get(0);
            int y0 = Game.Board.get(newPos).get(1);


            translate.setByY(y0 - yc);
            translate.setByX(x0 - xc);

            st.getChildren().add(translate);
        }

        if (Game.Snakes.containsKey(p.getPos())) {
            snake snk = Game.Snakes.get(p.getPos());
            int newPos = snk.end;
            p.setPosSnakeOrLadder(newPos);
            ArrayList<ArrayList<Integer>> pts = snk.all_points;
            int n = pts.size();
            for(int i = 1; i < n; i++) {
                TranslateTransition translate = new TranslateTransition(Duration.seconds(0.25), tok);
                int xc = pts.get(i - 1).get(0);
                int yc = pts.get(i - 1).get(1);
                int x0 = pts.get(i).get(0);
                int y0 = pts.get(i).get(1);
                translate.setByY(y0 - yc);
                translate.setByX(x0 - xc);
                st.getChildren().add(translate);
            }
        }

        st.play();
    }


    public void diceThrowControl(javafx.scene.input.MouseEvent mouseEvent) {
        arrow.setLayoutX(1000);
        arrow.setLayoutX(1000);
        Thread thread = new Thread() {
            int val = -1;

            public void run() {
                Random r = new Random();
                for (int i = 0; i < 15; i++) {
                    try {
                        val = r.nextInt(6) + 1;
                        testDice.setImage(new Image(String.valueOf(Main.class.getResource(val + ".png"))));
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                DiceValue = val;
                System.out.println(DiceValue);
            }
        };

        thread.start();
    }

    public void mouseOnDice(javafx.scene.input.MouseEvent mouseEvent) {
        testDice.setLayoutX(180.5);
        testDice.setLayoutY(640.5);
        testDice.setFitWidth(85);
        testDice.setFitHeight(85);
    }

    public void mouseOffDice(javafx.scene.input.MouseEvent mouseEvent) {
        testDice.setLayoutX(183);
        testDice.setLayoutY(644);
        testDice.setFitHeight(80);
        testDice.setFitWidth(80);
    }

    public void mouseOnBack(javafx.scene.input.MouseEvent mouseEvent) {
        backButton.setLayoutX(11.7);
        backButton.setLayoutY(12.6);
        backButton.setFitWidth(88);
        backButton.setFitHeight(55);
    }

    public void mouseOffBack(javafx.scene.input.MouseEvent mouseEvent) {
        backButton.setLayoutX(13);
        backButton.setLayoutY(14);
        backButton.setFitHeight(50);
        backButton.setFitWidth(80);
    }

    public int getDiceValue() {
        return this.DiceValue;
    }

    public void resetDice() {
        this.DiceValue = -1;
    }


    public void UseArrow() {
        arrow.setLayoutX(197);
        arrow.setLayoutY(580);
        arrow.setTranslateY(0);
        TranslateTransition tr = new TranslateTransition(Duration.millis(500), arrow);
        tr.setByY(10);
        tr.setAutoReverse(true);
        tr.setCycleCount(TranslateTransition.INDEFINITE);
        tr.play();
        tr.setOnFinished(event -> {
            arrow.setLayoutY(580);
            arrow.setTranslateY(0);
        });
    }

    public void diceThrowControlComputer() {
        arrow.setLayoutX(1000);
        arrow.setLayoutX(1000);
        Thread thread = new Thread() {
            int val = -1;

            public void run() {
                Random r = new Random();
                for (int i = 0; i < 15; i++) {
                    try {
                        val = r.nextInt(6) + 1;
                        testDice.setImage(new Image(String.valueOf(Main.class.getResource(val + ".png"))));
                        sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                DiceValue = val;
                System.out.println(DiceValue);
            }
        };

        thread.start();
    }

    @FXML
    public void getWarning() {
        no.setTranslateY(0);
        warning.setLayoutY(139);
        warning.setLayoutX(16);
        yes.setLayoutX(47);
        yes.setLayoutY(367);
        no.setLayoutX(273);
        no.setLayoutY(367);
    }

    @FXML
    void mouseOnNo(MouseEvent event) {
        no.setLayoutY(363);
        no.setLayoutX(269);
        no.setFitWidth(126.5);
        no.setFitHeight(106.7);
    }

    @FXML
    void mouseOnYes(MouseEvent event) {
        yes.setLayoutX(44);
        yes.setLayoutY(363);
        yes.setFitWidth(130.9);
        yes.setFitHeight(113.3);
    }

    @FXML
    void returnToGame(MouseEvent event) {
        no.setTranslateY(1000);
        yes.setLayoutY(1000);
        warning.setLayoutY(1000);
    }

    @FXML
    void returnToMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("startScreen.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void mouseOffNo(MouseEvent event) {
        no.setLayoutY(367);
        no.setLayoutX(273);
        no.setFitWidth(115);
        no.setFitHeight(97);
    }

    @FXML
    void mouseOffYes(MouseEvent event) {
        yes.setLayoutX(47);
        yes.setLayoutY(367);
        yes.setFitWidth(119);
        yes.setFitHeight(103);
    }

    @FXML
    public void getWinScreen(player winner) throws InterruptedException, IOException {
        sleep(5000);
        if(winner.getCol().equals("blue")) {
            blueWin.setLayoutX(21);
            blueWin.setLayoutY(142);
        } else {
            greenWin.setLayoutX(21);
            greenWin.setLayoutY(142);
        }
        sleep(3000);

        greenWin.setLayoutX(1000);
        greenWin.setLayoutY(1000);
        blueWin.setLayoutX(1000);
        blueWin.setLayoutY(1000);
    }
}