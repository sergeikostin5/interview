package recursion;

import utils.ArrayHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 12/25/17.
 */
public class SudokuSolver {

    private static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public boolean solveSudoku(int[][] board){
        return solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(int[][] board, int row, int col){

        Position current = getNextFreePos(board, row, col);
        if(current == null) return true;

        for(Integer value : getCandidates(board, current)){
            board[current.x][current.y] = value;
            if(solveSudoku(board, current.x, current.y)) return true;
        }

        board[row][col] = 0;
        return false;
    }

    private List<Integer> getCandidates(int[][] board, Position current) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i<10; i++){
            if(isValidRow(board, i, current) && isValidCol(board, i, current) && isValidBox(board, i, current)) result.add(i); 
        }
        
        return result;
    }

    private boolean isValidBox(int[][] board, int value, Position current) {

        int xOffset = (current.x/3)*3;
        int yOffset = (current.y/3)*3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i+xOffset][j+yOffset] == value) return false;
            }
        }
        return true;

    }

    private boolean isValidRow(int[][] board, int value, Position current) {
        for(int i = 0; i < board.length; i++){
            if(board[i][current.y] == value) return false;
        }
        return true;
    }

    private boolean isValidCol(int[][] board, int value, Position current) {
        for(int i = 0; i < board.length; i++){
            if(board[current.x][i] == value) return false;
        }
        return true;
    }
    
    

    private Position getNextFreePos(int[][] board, int row, int col) {
        for(int i = row; i < board.length; i++ ){
            for(int j = 0; j<board.length; j++){
                if(board[i][j] == 0) return new Position(i,j);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[][] board = new int[9][9];
        board[0][0] = 5;
        board[0][1] = 3;
        board[0][4] = 7;
        board[1][0] = 6;
        board[1][3] = 1;
        board[1][4] = 9;
        board[1][5] = 5;
        board[2][1] = 9;
        board[2][2] = 8;
        board[2][7] = 6;
        board[3][0] = 8;
        board[3][4] = 6;
        board[3][8] = 3;
        board[4][0] = 4;
        board[4][3] = 8;
        board[4][5] = 3;
        board[4][8] = 1;
        board[5][0] = 7;
        board[5][4] = 2;
        board[5][8] = 6;
        board[6][1] = 6;
        board[6][6] = 2;
        board[6][7] = 8;
        board[7][3] = 4;
        board[7][4] = 1;
        board[7][5] = 9;
        board[7][8] = 5;
        board[7][4] = 1;
        board[8][4] = 8;
        board[8][7] = 7;
        board[8][8] = 9;

        ArrayHelper.print2DIntArray(board);

        SudokuSolver ss = new SudokuSolver();
        System.out.println();
        if(ss.solveSudoku(board)) System.out.println("Here is solution");
        else System.out.println("Solution doesn't exist");
        ArrayHelper.print2DIntArray(board);

    }

}
