package com.kodilla.rps.players;

import java.util.Random;

public class Computer implements Side {
    private String name = "Computer";
    private int winRounds;
    Random generator = new Random();

    public String getName() {
        return name;
    }

    @Override
    public String chooseMove() {
        Integer number = generator.nextInt(3) +1;
        String result = number.toString();
        return result;
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
