package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class player {

    private final String col;
    private boolean open;
    private int pos;
    private playerController pc;

    player(playerController pc, String col) {
        this.pos = 0;
        this.pc = pc;
        this.col = col;
        this.open = false;
    }

    void playerReset() {
        this.pos = 0;
        this.open = false;
    }
    public int getPos() {
        return this.pos;
    }

    public void setPos(int val) {
        this.pos += val;
    }

    public void setPosSnakeOrLadder(int val) { this.pos = val; }

    public boolean isOpen() {
        return this.open;
    }

    public String getCol() {
        return this.col;
    }

    public void setOpen() {
        this.open = true;
    }
}
