package main.player;

// The Clever Builder: a player that tries to build a column, when picking another column, pick one with more than 4 spaces

import main.Board;
import main.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CleverBuilderPlayer extends Player {

    int targetCol;
    Random rando = new Random();

    private void randomCol(){
        targetCol = rando.nextInt(Board.cols);
    }

    private void pickCol(Board board) {
        List<Integer> columns = new ArrayList<>();
        for(int col = 0; col < Board.cols; col++){
            if(board.columnSpaces(col) >= 4){
                columns.add(col);
            }
        }
        targetCol = columns.isEmpty()
                ? rando.nextInt(Board.cols)
                : columns.get(rando.nextInt(columns.size()));
    }

    public CleverBuilderPlayer(char counter, String name){
        super(counter, name);
        randomCol();
    }

    public Move decideMove(Board board){
        if(board.isColumnFull(targetCol)){
            pickCol(board);
        }
        return new Move(targetCol, counter);
    }
}