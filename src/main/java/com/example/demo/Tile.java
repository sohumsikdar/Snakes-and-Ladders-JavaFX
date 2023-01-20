package com.example.demo;

public class Tile {

    private int tileStart;
    private int tileEnd;
    private int nextTileX;

    private int nextTileY;


    public Tile(int tileStart, int tileEnd, int nextTileX, int nextTileY) {
        this.tileStart = tileStart;
        this.tileEnd = tileEnd;
        this.nextTileX = nextTileX;
        this.nextTileY = nextTileY;
    }

    public int getTileStart() {

        return tileStart;
    }

    public int getTileEnd() {

        return tileEnd;
    }

    public void setTileEnd(int tileEnd) {

        this.tileEnd = tileEnd;
    }
    public int getNextTileX() {

        return nextTileX;
    }

    public int getNextTileY() {

        return nextTileY;
    }
}
