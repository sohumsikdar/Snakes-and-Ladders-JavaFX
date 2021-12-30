package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class Main extends Application {
    static playerController pc;
    static player p1;
    static player p2;

    @FXML
    ImageView blue;
    @FXML
    ImageView green;

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startScreen.fxml"));
            Parent root = loader.load();
//            pc = (playerController) loader.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(String.valueOf(Main.class.getResource("stylesheet.css")));
            Image icon = new Image(String.valueOf(Main.class.getResource("icon.png")));
            stage.getIcons().add(icon);
            stage.setTitle("Snakes and Ladders");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();


            Game game = new Game();
//            Game.dbgSnakes();
            p1 = new player(pc, "blue");
            p2 = new player(pc, "green");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startNewGame(boolean computer) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                pc.resetDice();
                p1.playerReset();
                p2.playerReset();
                while(p1.getPos() != 100 && p2.getPos() != 100) {
                    try {
                        pc.UseArrow();
                        if(p1.getPos() == 100 || p2.getPos() == 100) {
                            player winner = p1.getPos() == 100 ? p1 : p2;
                            try {
                                pc.getWinScreen(winner);
                            } catch (InterruptedException | IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        }
                        while (pc.getDiceValue() == -1) {
                            sleep(500);
                        }
                        System.out.println("here");
                        pc.moves(p1);
                        pc.resetDice();
                        System.out.println(p1.getPos());
                        sleep(1500);
                        if(!computer) {
                            pc.UseArrow();
                            if(p1.getPos() == 100 || p2.getPos() == 100) {
                                player winner = p1.getPos() == 100 ? p1 : p2;
                                try {
                                    pc.getWinScreen(winner);
                                } catch (InterruptedException | IOException e) {
                                    e.printStackTrace();
                                }

                                break;
                            }
                            while (pc.getDiceValue() == -1) {
                                sleep(500);
                            }
                            System.out.println("here");
                            pc.moves(p2);
                            pc.resetDice();
                        } else {
                            pc.diceThrowControlComputer();
                            while (pc.getDiceValue() == -1) {
                                sleep(500);
                            }
                            System.out.println("here");
                            pc.moves(p2);
                            pc.resetDice();

                        }
                        sleep(1500);
                        System.out.println(p2.getPos());

                        if(p1.getPos() == 100 || p2.getPos() == 100) {
                            player winner = p1.getPos() == 100 ? p1 : p2;
                            try {
                                pc.getWinScreen(winner);
                            } catch (InterruptedException | IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}