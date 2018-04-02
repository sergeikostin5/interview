package recursion;

import utils.ArrayHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 3/31/18.
 */
public class SudokuSolver_237 {

    private static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col){
        Position current = getNextCandidate(board, row);

        if(current == null) return true;

        List<Integer> candidates  = getListOfCandidates(board, current.x, current.y);

        if(candidates.isEmpty()) return false;

        for(Integer i :candidates){
            board[current.x][current.y] = (char)(i + '0');
            if(solveSudoku(board, current.x, current.y)) return true;
            board[current.x][current.y] = '.';
        }

        return false;
    }

    private Position getNextCandidate(char[][] board, int row){
        for(int i = row; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') return new Position(i,j);
            }
        }
        return null;
    }

    private List<Integer> getListOfCandidates(char[][] board, int row, int col){
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            if(isValidRow(board, row, i) && isValidCol(board, col, i) && isValidBox(board, row, col, i)) result.add(i);
        }
        return result;
    }

    private boolean isValidRow(char[][] board, int row, int num){
        for(int i = 0; i< board.length; i++){
            if(board[row][i] == (char)(num+'0')) return false;
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col, int num){
        for(int i = 0; i< board.length; i++){
            if(board[i][col] == (char)(num+'0')) return false;
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int row, int col, int num){
        int beginRow = (row/3)*3;
        int beginCol = (col/3)*3;
        for(int i = beginRow; i< beginRow+3; i++){
            for(int j = beginCol; j < beginCol + 3; j++) {
                if (board[i][j] == (char) (num + '0')) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        for(int i = 0; i < board.length; i++){
            for(int j  = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }
        board[0][0] = '5';
        board[0][1] = '3';
        board[0][4] = '7';
        board[1][0] = '6';
        board[1][3] = '1';
        board[1][4] = '9';
        board[1][5] = '5';
        board[2][1] = '9';
        board[2][2] = '8';
        board[2][7] = '6';
        board[3][0] = '8';
        board[3][4] = '6';
        board[3][8] = '3';
        board[4][0] = '4';
        board[4][3] = '8';
        board[4][5] = '3';
        board[4][8] = '1';
        board[5][0] = '7';
        board[5][4] = '2';
        board[5][8] = '6';
        board[6][1] = '6';
        board[6][6] = '2';
        board[6][7] = '8';
        board[7][3] = '4';
        board[7][4] = '1';
        board[7][5] = '9';
        board[7][8] = '5';
        board[7][4] = '1';
        board[8][4] = '8';
        board[8][7] = '7';
        board[8][8] = '9';

        ArrayHelper.print2DCharArray(board);

        SudokuSolver_237 ss = new SudokuSolver_237();
        ss.solveSudoku(board);
        System.out.println();
//        ss.solveSudoku(board)) System.out.println("Here is solution");
//        else System.out.println("Solution doesn't exist");
        ArrayHelper.print2DCharArray(board);

    }

}
