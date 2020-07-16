package main;

public class Board {

    char[][] tiles;
    Cell lastMove;
    public static int rows;
    public static int cols;

    public Board(int rows, int cols){
        tiles = new char[rows][cols];
        Board.rows = rows;
        Board.cols = cols;
    }

    public Cell getLastMove() {
        return lastMove;
    }

    //lowest unoccupied tile in column. traverse backwards length of column and return index of first unoccupied
    private int getDeepest(int col){
        for(int row = (rows - 1); row >= 0; row--){
            if(tiles[row][col] == '\0'){
                return row;
            }
        }
        return -1;                  // not a valid reference in an array
    }

    public void makeMove(Move move){
        int row = getDeepest(move.col);
        tiles[row][move.col] = move.counter;
        lastMove = new Cell(row, move.col);
    }

    public boolean isValid (Move move){
        if(move.col < 0  || move.col > (cols - 1) || getDeepest(move.col) == -1){
            return false;
        }
        return true;
    }

    boolean isFull(){                           // refactor / adapt?
        for(char tile : tiles[0]){
            if(tile == '\0'){
                return false;
            }
        }
        return true;
    }

    public boolean isColumnFull(int col) {
        return tiles[0][col] != '\0';
    }

    public int columnSpaces(int col){
        int spaces = 0;
        for(int i = 0; i < rows; i++){
            char c = tiles[i][col];
            if(c != '\0'){
                return spaces;
            }
            spaces++;
        }
        return spaces;
    }

    private String renderCell(char c) {
        return c == '\0' ? "_" : String.valueOf(c);
    }      //  valueOf returns the primitive value of a String object as a string data type

    void show(){
        System.out.println("");
        for(int row = 0; row < rows; row++){
            String line = "|";
            for (int col = 0; col < cols; col++) {
                line += renderCell(tiles[row][col]) + "|";
            }
            System.out.println(line);
        }
        System.out.println("");
    }
}
