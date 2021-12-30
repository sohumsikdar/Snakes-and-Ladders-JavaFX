package com.example.demo;

import java.util.ArrayList;

public class snake {
    protected int start;
    protected int end;
    protected ArrayList<ArrayList<Integer>> all_points = new ArrayList<>();

    snake(int s, int e) {
        this.start = s;
        this.end = e;
    }

    public void putPoints(Integer x, Integer y){
        ArrayList<Integer> ap = new ArrayList<>();
        ap.add(x);
        ap.add(y);

        this.all_points.add(ap);
    }

    public ArrayList<ArrayList<Integer>> getAll_points(){
        return all_points;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
