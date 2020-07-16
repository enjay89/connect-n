package main.player;

// The Builder: a player that tries to build a column

import main.Board;
import main.Move;

import java.util.Random;

public class BuilderPlayer extends Player {

    int targetCol;

    private void randomCol() {
        Random rand = new Random();
        targetCol = rand.nextInt(7);
    }

    public BuilderPlayer(char counter, String name){
        super(counter, name);
        randomCol();
    }

    public Move decideMove(Board board){
        if(board.isColumnFull(targetCol)){
            randomCol();
        }
        return new Move(targetCol, counter);
    }
}
