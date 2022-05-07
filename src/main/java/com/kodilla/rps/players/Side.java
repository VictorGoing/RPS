package com.kodilla.rps.players;

public interface Side {
    String chooseMove();
    String getName();
    void addVictoryRound();
    int getWinRounds();
    void resetWinCounter();
}
