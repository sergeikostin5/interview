package recursion;

import utils.ArrayHelper;

/**
 * Created by sergei.kostin on 12/25/17.
 */
public class MazeSolver {

    public boolean findPath(int[][] board) {

        return findPath(board, 3, 0);

    }

    private boolean findPath(int[][] board, int row, int col){

        if(row == board.length - 1 && col == board.length - 1){
            board[row][col] = 1;
            return true;
        }
        if(row == board.length || col == board.length || row < 0 || col < 0 || board[row][col] == -1 || board[row][col] == 1) return false;

        board[row][col] = 1;

        if(findPath(board, row +1, col)) return true;
        if(findPath(board, row -1, col)) return true;
        if(findPath(board, row, col-1)) return true;
        if(findPath(board, row, col+1)) return true;
        board[row][col] = 0;
        return false;
    }



    public static void main(String[] args) {
        int[][] board = new int[4][4];
        board[1][1] = -1;
        board[2][1] = -1;
        board[3][1] = -1;
        board[3][2] = -1;
        board[1][3] = -1;
        ArrayHelper.print2DIntArray(board);
        System.out.println();
        MazeSolver ms = new MazeSolver();
        if(ms.findPath(board)) ArrayHelper.print2DIntArray(board);
        else System.out.println("There is no solution!!!");
    }

}
