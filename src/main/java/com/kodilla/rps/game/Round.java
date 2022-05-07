package com.kodilla.rps.game;

import com.kodilla.rps.players.Player;
import com.kodilla.rps.players.Side;

public class Round {
    private int number;
    private Move playerMove;
    private Move computerMove;
    private String result;

    public Round(int number, Move playerMove, Move computerMove, String result) {
        this.number = number;
        this.playerMove = playerMove;
        this.computerMove = computerMove;
        this.result = result;
    }

    public int getNumber() {
        return number;
    }

    public Move getPlayerMove() {
        return playerMove;
    }

    public Move getComputerMove() {
        return computerMove;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        System.out.println(" ");
        return "Round " + number +
                ", player move " + playerMove.getResult() +
                ", computer move= " + computerMove.getResult() +
                ", result='" + result + '\'' +
                '}';
    }
}
