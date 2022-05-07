package com.kodilla.rps.game;

import com.kodilla.rps.players.Side;

import java.util.List;

public class GameStats {
    private List<Round> rounds;

    public List<Round> getRounds() {
        return rounds;
    }

    public GameStats(List<Round> rounds) {
        this.rounds = rounds;
    }


    public void newRound(int i,Side player,Side computer){
        Move playerMove = new Move(player);
        playerMove.chooseFigure();
        Move computerMove = new Move(computer);
        computerMove.chooseFigure();
        String result = fight(playerMove.getResult(), computerMove.getResult(),player.getName());
        rounds.add(new Round(i,playerMove,computerMove,result));
    }

    private String fight(String playerFigure, String computerFigure,String playerName){
        switch (playerFigure){
            case "Rock":
                switch (computerFigure){
                    case "Rock":
                        return "Draw";
                    case "Paper":
                        return "Computer";
                    case "Scissors":
                        return playerName;
                }
            case "Paper":
                switch (computerFigure){
                    case "Rock":
                        return playerName;
                    case "Paper":
                        return "Draw";
                    case "Scissors":
                        return "Computer";
                }
            case "Scissors":
                switch (computerFigure){
                    case "Rock":
                        return "Computer";
                    case "Paper":
                        return playerName;
                    case "Scissors":
                        return "Draw";
                }
        }
        return "ERROR";
    }

    public void showStats(String playerName, int playerCounter, int computerCounter){
        System.out.println(" ");
        System.out.println(playerName + " " + playerCounter + ":" + computerCounter + " Computer");
        System.out.println(" ");
        if(playerCounter>computerCounter) System.out.println(playerName + " WIN!!!");
        else System.out.println("Computer win :(");
        System.out.println(" ");
    }
}
