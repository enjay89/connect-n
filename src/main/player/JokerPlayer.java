package main.player;

import main.Board;
import main.Move;

import java.util.Random;

//The Joker: a player that moves at random

public class JokerPlayer extends Player {

    public JokerPlayer(char counter, String name){
        super(counter, name);
    }

    public Move decideMove(Board board){
        Random rand = new Random();
        int col = rand.nextInt(Board.cols);
        return new Move(col, counter);
    }
}