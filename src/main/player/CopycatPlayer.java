package main.player;

// The Copycat: a player that copies the last move

import main.Board;
import main.Move;

import java.util.Random;

public class CopycatPlayer extends Player{

    Random rand = new Random();

    public CopycatPlayer(char counter, String name) {
        super(counter, name);
    }

    @Override
    public Move decideMove(Board board) {
        int lastMove = board.getLastMove().getColumn();
        int targetCol = lastMove;
        if(board.isColumnFull(lastMove)){
            targetCol = rand.nextInt(Board.cols);
        }
        return new Move(targetCol, counter);
    }
}
