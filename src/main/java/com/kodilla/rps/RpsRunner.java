package com.kodilla.rps;

import com.kodilla.rps.game.Game;

public class RpsRunner {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Game game = new Game();
        game.gameOn();
    }
}
