package arrays;

import utils.ArrayHelper;

/**
 * Created by sergei.kostin on 3/31/18.
 */
public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(!isValidRow(board, i, j) || !isValidCol(board, i, j) || !isValidBox(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int i, int j) {
        char num = board[i][j];
        for(int k = 0; k < board.length; k++ ){
            if(k == j) continue;
            if(board[i][k] == num) return false;
        }

        return true;
    }

    private boolean isValidCol(char[][] board, int i, int j) {
        char num = board[i][j];
        for(int k = 0; k < board[0].length; k++ ){
            if(k == i) continue;
            if(board[k][j] == num) return false;
        }

        return true;
    }

    private boolean isValidBox(char[][] board, int i, int j) {
        char num = board[i][j];
        int beginRow = (i/3)*3;
        int beginCol = (j/3)*3;
        for(int row = beginRow; row < beginRow+3; row++){
            for(int col = beginCol; col < beginCol + 3; col++){
                if(row == i && col == j) continue;
                if(board[row][col] == num) return false;
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
        board[0][2] = '2';
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

        ValidSudoku_36 ss = new ValidSudoku_36();
        System.out.println(ss.isValidSudoku(board));
    }


}
