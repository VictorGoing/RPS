package com.kodilla.rps.game;

import com.kodilla.rps.players.Computer;
import com.kodilla.rps.players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private boolean end = false;
    private GameStats stats;
    private Player player;
    private Computer computer;
    private int roundsToWin;


    public Game() {
        this.stats = new GameStats(new ArrayList<>());
        this.computer = new Computer();
    }

    public void gameOn(){
        System.out.println("Welcome to RPS!");
        startGame();
        int i = 1;
        while (!end){
            System.out.println("Round: " + i);
            System.out.print("Choose your figure: ");
            stats.newRound(i,player,computer);
            if(playerCommand(stats.getRounds().get(i-1).getPlayerMove().getResult())){
                resultInterpreter(stats.getRounds().get(i-1).getResult());
                System.out.print(player.getName() + ": " + stats.getRounds().get(i-1).getPlayerMove().getResult() +" vs " );
                System.out.print(computer.getName() + ": " + stats.getRounds().get(i-1).getComputerMove().getResult() + " point for: ");
                System.out.println(stats.getRounds().get(i-1).getResult());
            }
            else{
                i = 0;
                countersReset();
            }
            i++;
            endGame();
        }
        stats.showStats(player.getName() ,player.getWinRounds(), computer.getWinRounds());
        playAgain();
    }

    private void startGame(){
        System.out.println("Please, add your name.");
        System.out.print("name: ");
        this.player = addPlayer();
        System.out.println("Welcome, " + player.getName());
        System.out.println("Please, give number of rounds required to win.");
        numberOfRounds();
        howToPlay();
    }


    private Player addPlayer(){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        return new Player(name);
    }

    private void numberOfRounds(){
        Scanner sc = new Scanner(System.in);
        this.roundsToWin = sc.nextInt();
    }

    private void howToPlay() {
        System.out.println("How to play?");
        System.out.println("Key '1' to choose stone");
        System.out.println("Key '2' to choose paper");
        System.out.println("Key '3' to choose scissors");
        System.out.println("Key 'x' to exit game");
        System.out.println("Key 'n' to reset game");
        System.out.println("Ready?");
        System.out.println(" ");
        System.out.println("Start!");
    }

    private void resultInterpreter(String side){
        if(side.equals("Computer")) computer.addVictoryRound();
        if(side.equals(player.getName())) player.addVictoryRound();
    }

    private boolean playerCommand(String command){
        if(command.equals("n")){
            this.stats = new GameStats(new ArrayList<>());
            return false;
        }
        if(command.equals("x")){
            this.end = true;
            return false;
        }
        return true;
    }

    private void endGame(){
        if(player.getWinRounds() == roundsToWin||computer.getWinRounds() == roundsToWin) this.end = true;
    }

    private void playAgain(){
        System.out.println("put 'n' to PLAY AGAIN, put 'x' to EXIT");
        String key = "";
        do {
            Scanner sc = new Scanner(System.in);
            key = sc.next();
        }while ( ! ( key.equals("n") || key.equals("x") ) );
        if(key.equals("n")){
            this.end = false;
            this.stats = new GameStats(new ArrayList<>());
            countersReset();
            gameOn();
        }
    }

    private void countersReset(){
        player.resetWinCounter();
        computer.resetWinCounter();
    }
}
