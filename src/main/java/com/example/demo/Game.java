package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    public static HashMap<Integer, ArrayList<Integer>> Board = new HashMap<>();
    //Hashes start to snake
    public static HashMap<Integer, snake> Snakes = new HashMap<>();
    //Hashes start to ladder
    public static HashMap<Integer, ladder> Ladders = new HashMap<>();

    public Game() {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(18);
        arr.add(558);
        Board.put(0, arr);

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(535);
            Board.put(i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(481);
            Board.put(21-i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(434);
            Board.put(20+i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(387);
            Board.put(41-i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(336);
            Board.put(40+i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(288);
            Board.put(61-i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(238);
            Board.put(60+i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(192);
            Board.put(81-i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(142);
            Board.put(80+i,x);
        }

        for (int i=1; i<=10; i++){
            ArrayList<Integer> x = new ArrayList<>();
            x.add(23+((i-1)*42));
            x.add(95);
            Board.put(101-i,x);
        }

        snake a15 = new snake(15, 5);
        a15.putPoints(233, 481);
        a15.putPoints(190, 510);
        a15.putPoints(229, 540);
        a15.putPoints(191, 535);
        Snakes.put(15, a15);

        snake a22 = new snake(22, 2);
        a22.putPoints(65, 434);
        a22.putPoints(53, 473);
        a22.putPoints(79, 511);
        a22.putPoints(65 ,535);
        Snakes.put(22, a22);

        snake a33 = new snake(33, 8);
        a33.putPoints(317, 387);
        a33.putPoints(336, 424);
        a33.putPoints(312, 457);
        a33.putPoints(326 ,487);
        a33.putPoints(312, 510);
        a33.putPoints(317, 535);
        Snakes.put(33, a33);

        snake a44 = new snake(44, 23);
        a44.putPoints(149, 336);
        a44.putPoints(111, 375);
        a44.putPoints(147, 417);
        a44.putPoints(107, 434);
        Snakes.put(44, a44);

        snake a68 = new snake(68, 50);
        a68.putPoints(317, 238);
        a68.putPoints(374, 273);
        a68.putPoints(323, 305);
        a68.putPoints(393,329);
        a68.putPoints(375, 335);
        a68.putPoints(401, 336);
        Snakes.put(68, a68);

        snake a79 = new snake(79, 43);
        a79.putPoints(65, 192);
        a79.putPoints(109, 228);
        a79.putPoints(71, 274);
        a79.putPoints(114, 317);
        a79.putPoints(79, 345);
        a79.putPoints(107, 336);
        Snakes.put(79, a79);

        snake a85 = new snake(85, 65);
        a85.putPoints(191, 142);
        a85.putPoints(209, 183);
        a85.putPoints(183, 218);
        a85.putPoints(191, 238);
        Snakes.put(85, a85);

        snake a92 = new snake(92, 71);
        a92.putPoints(359, 95);
        a92.putPoints(408, 130);
        a92.putPoints(373, 173);
        a92.putPoints(401, 192);
        Snakes.put(92, a92);

        snake a94 = new snake(94, 47);
        a94.putPoints(275, 95);
        a94.putPoints(271, 135);
        a94.putPoints(293, 170);
        a94.putPoints(270, 210);
        a94.putPoints(292, 254);
        a94.putPoints(271, 293);
        a94.putPoints(275, 336);
        Snakes.put(94, a94);

        snake a98 = new snake(98, 82);
        a98.putPoints(107, 95);
        a98.putPoints(70, 127);
        a98.putPoints(108, 155);
        a98.putPoints(65, 142);
        Snakes.put(98, a98);

        Ladders.put(3, new ladder(3, 24));
        Ladders.put(7, new ladder(7, 34));
        Ladders.put(12, new ladder(12, 31));
        Ladders.put(20, new ladder(20, 41));
        Ladders.put(36, new ladder(36, 46));
        Ladders.put(56, new ladder(56, 63));
        Ladders.put(60, new ladder(60, 81));
        Ladders.put(69, new ladder(69, 93));
        Ladders.put(75, new ladder(75, 95));
        Ladders.put(78, new ladder(78, 97));
    }
}
