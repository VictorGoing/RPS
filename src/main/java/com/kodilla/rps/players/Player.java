package com.kodilla.rps.players;

import com.kodilla.rps.game.Figure;

import java.util.Scanner;

public class Player implements Side{
    private String name;
    private int winRounds;
    Figure figure = new Figure();

    public Player(String name) {
        this.name = name;
        this.winRounds = 0;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String chooseMove(){
        Scanner sc = new Scanner(System.in);
        return  sc.next();
    }

    @Override
    public void addVictoryRound() {
        this.winRounds++;
    }

    @Override
    public int getWinRounds() {
        return winRounds;
    }

    @Override
    public void resetWinCounter(){
        this.winRounds = 0;
    }

}
