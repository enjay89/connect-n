package main.player;

//The Plumber: a player that tries to build a row

import main.Board;
import main.Move;

public class PlumberPlayer extends Player {

    int lastColumn;

    public PlumberPlayer(char counter, String name){
        super(counter, name);
        lastColumn = -1;
    }

    public Move decideMove(Board board){
        if(lastColumn == 6){
            lastColumn = 0;
        } else {
            lastColumn++;
        }
        return new Move(lastColumn, counter);
    }
}
