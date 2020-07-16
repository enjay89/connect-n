package main;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    int winCounters;

    Game game;
    public Judge(Game game, int winCounters){
        this.game = game;
        this.winCounters = winCounters;
    }

    boolean hasWon(char[][] board, char counter){
        //columns
        List<Character> colChars = new ArrayList<>();
        for(int row = 0; row < Board.rows; row++){
            colChars.add(board[row][game.board.lastMove.column]);
        }
        if(containsWin(colChars, counter)){
            return true;
        }
        //rows
        List<Character> rowChars = new ArrayList<>();
        for(int col = 0; col < Board.cols; col++){
            rowChars.add(board[game.board.lastMove.row][col]);
        }
        if(containsWin(rowChars, counter)){
            return true;
        }
        //diagonals
        return isDiagWin(counter);
    }


    private boolean containsWin(List<Character> characters, char counter){
        int i = 0;
        for(Character character : characters){
            if(character.equals(counter)){
                i++;
                if(i == winCounters){
                    return true;
                }
            } else {
                i = 0;
            }
        }
        return false;
    }

    private boolean isDiagWin(char counter){
        char[][] tiles = game.board.tiles;
        int lastMoveRow = game.board.lastMove.row;
        int lastMoveCol = game.board.lastMove.column;
        int row = lastMoveRow;
        int col = lastMoveCol;
        List<Character> diagChars1 = new ArrayList<>();
        List<Character> diagChars2 = new ArrayList<>();

        while(true){
            try {
                char c = tiles[row +1][col -1];
                row++;
                col--;
            } catch(IndexOutOfBoundsException e){
                break;
            }
        }


        while(true){
            try {
                diagChars1.add(tiles[row][col]);
                row--;
                col++;
            } catch(IndexOutOfBoundsException e){
                break;
            }
        }

        if(containsWin(diagChars1, counter)){
            return true;
        }

        row = lastMoveRow;
        col = lastMoveCol;

        while(true){
            try {
                char c = tiles[row -1][col -1];
                row--;
                col--;
            } catch(IndexOutOfBoundsException e){
                break;
            }
        }

        while(true){
            try {
                diagChars2.add(tiles[row][col]);
                row++;
                col++;
            } catch(IndexOutOfBoundsException e){
                break;
            }
        }
        return containsWin(diagChars2, counter);
    }
}
