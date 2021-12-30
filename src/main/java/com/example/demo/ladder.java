package com.example.demo;

public class ladder {
    protected int start;
    protected int end;

    ladder(int s, int e) {
        this.start = s;
        this.end = e;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
