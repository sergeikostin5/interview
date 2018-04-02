package arrays;

import utils.ArrayHelper;

/**
 * Created by sergei.kostin on 3/31/18.
 */
public class GameOfLife_289 {


//    1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//    2. Any live cell with two or three live neighbors lives on to the next generation.
//    3. Any live cell with more than three live neighbors dies, as if by over-population..
//    4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int numNeighbors = getNumberOfNeighbors(newBoard, i, j);
                if(board[i][j] == 1) {
                    if (numNeighbors < 2) board[i][j] = 0;
                    else if (numNeighbors > 3) board[i][j] = 0;
                } else {
                    if(numNeighbors == 3) board[i][j] = 1;
                }
            }
        }
    }

    public int getNumberOfNeighbors(int[][] board, int row, int col){
        int startRow = Math.max(0, row - 1);
        int startCol = Math.max(0, col - 1);
        int result = 0;
        for(int i = startRow; i < row +2 && i < board.length; i++ ){
            for(int j = startCol; j < col + 2 && j < board[0].length; j++ ){
                if(i == row && j == col) continue;
                if(board[i][j] == 1) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] board = {{1}};
//                {
//                {1,0,0,1},
//                {1,1,1,1},
//                {0,0,0,0},
//                {0,1,1,0},
//        };
        GameOfLife_289 gol = new GameOfLife_289();
        gol.gameOfLife(board);
        ArrayHelper.print2DIntArray(board);

    }
}
