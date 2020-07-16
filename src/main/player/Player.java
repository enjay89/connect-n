package main.player;

import main.Board;
import main.Move;

public abstract class Player{

    public char counter;
    public String name;

    public Player(char counter, String name){
        this.counter = counter;
        this.name = name;
    }

    public abstract Move decideMove(Board board);
}
