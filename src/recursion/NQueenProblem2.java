package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 3/13/18.
 */
public class NQueenProblem2 {

    public List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        initBoard(board);
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solveNQueens(n, 0,board,result,temp);
        return result;
    }

    private void solveNQueens(int n, int row, char[][] board, List<List<String>> result, List<String> temp){
        if(row == n) {
            List<String> list = new ArrayList<>(temp);
            result.add(list);
            return;
        }
        for(int i = 0; i < board[0].length; i++){
            if(isValid(row, i, board)){
                temp.add(createString(n, i));
                board[row][i] = 'Q';
                solveNQueens(n, row+1, board, result, temp);
                board[row][i] = '-';
                temp.remove(temp.size()-1);
            }
        }
    }

    private void initBoard( char[][] board){
        for(int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = '-';
            }
        }
    }

    private String createString(int n, int k){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++){
            builder.append(i == k ? 'Q' : '.');
        }
        return builder.toString();
    }

    private boolean isValid(int row, int col, char[][] board){
        // check row
        for(int i = 0; i < board[0].length; i++ ){
            if(board[row][i] == 'Q') return false;
        }

        // check col
        for(int i = 0; i < board.length; i++ ){
            if(board[i][col] == 'Q') return false;
        }

        // check diagonals
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i+j == row + col && board[i][j] == 'Q') return false;
                if(j-i == col - row && board[i][j] == 'Q') return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NQueenProblem2 nqp = new NQueenProblem2();
        List<List<String>> result = nqp.solveNQueens(4);
        for(List<String> elem : result){
            for(String s : elem){
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
