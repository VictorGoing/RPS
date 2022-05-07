package com.kodilla.rps.game;

import com.kodilla.rps.players.Side;

import java.util.Scanner;

public class Move {
    private Side side;
    private Figure figure = new Figure();
    private String result;

    public Move(Side side) {
        this.side = side;
    }

    public Side getSide() {
        return side;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getResult() {
        return result;
    }

    private boolean question(String command){
        System.out.println("put 'y' to YES, put 'n' to NO");
        String key = "";
        do {
            Scanner sc = new Scanner(System.in);
            key = sc.next();
        }while ( ! ( key.equals("y") || key.equals("n") ) );
        if(key.equals("y")) return true;
        else return false;
    }


    public void chooseFigure(){
        String number = side.chooseMove();
        switch (number) {
            case "1":
                this.result = getFigure().getROCK();
                break;
            case "2":
                this.result = getFigure().getPAPER();
                break;
            case "3":
                this.result = getFigure().getSCISSORS();
                break;
            case "x":
                System.out.println("Do you really want exit game?");
                if(question("x"))
                    this.result = "x";
                else
                    chooseFigure();
                break;
            case "n":
                System.out.println("Do you really want restart game?");
                if(question("n"))
                    this.result = "n";
                else
                    chooseFigure();
                break;
            default:
                chooseFigure();
                break;
        }
    }
}
