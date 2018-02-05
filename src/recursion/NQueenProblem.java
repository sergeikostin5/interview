package recursion;

import utils.ArrayHelper;

/**
 * Created by sergei.kostin on 12/24/17.
 */
public class NQueenProblem {

    public void printNQueen(char[][] board){
        if(getSolution(board, 0)){
            ArrayHelper.print2DCharArray(board);
        }else{
            System.out.printf("There is no solution for board %sx%s", board.length, board[0].length);
        }
    }

    private boolean getSolution(char[][] board, int col) {

        if(board[0].length == col){
            return true;
        }

        for(int row = 0; row < board.length; row++){
            if(isValidSpot(board, row, col)){
                board[row][col] = 'Q';
                if(getSolution(board, col + 1)) return true;
                else board[row][col] = '-';
            }
        }
        return false;
    }

    private boolean isValidSpot(char[][] board, int row, int col){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q'){
                    if(row == i || col == j) return false;
                    else if(i-j == row - col || i+j == row+col) return false;
                    else continue;
                }
            }
        }
        return true;
    }

    private void init(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = '-';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[30][30];
        NQueenProblem nq = new NQueenProblem();
        nq.init(board);
        nq.printNQueen(board);

    }
}
