package recursion;

import utils.ArrayHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sergei.kostin on 12/25/17.
 */
public class KnightsTour {

    private int[] xMoves = {2,2,1,-1,-2,-2,-1,1};
    private int[] yMoves = {1,-1,-2,-2,-1,1,2,2};

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

    public boolean isKnightTour(int[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                Position pos = new Position(row,col);
                board[row][col] = 1;
                if(isKnightTour(board,1,pos)) return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isKnightTour(int[][] board, int counter, Position curPos){

        for(Position elem : getAvailablePos( board, curPos )){
            counter++;
            board[elem.x][elem.y] = counter;
            if(counter == board.length * board.length || isKnightTour(board, counter, elem)) return true;
            board[elem.x][elem.y] = 0;
            counter--;
        }
        return false;
    }

    private List<Position> getAvailablePos(int[][] board, Position curPos) {
        List<Position> result = new LinkedList<>();
        for(int i = 0; i < 8; i++){
            Position pos = new Position(curPos.x + xMoves[i], curPos.y + yMoves[i]);
            if(isValidPos(board, pos)){
                result.add(pos);
            }
        }
        return result;

    }

    private boolean isValidPos(int[][] board, Position curPos) {
        return curPos.x >= 0 && curPos.y >= 0 && curPos.x < board.length && curPos.y < board.length && board[curPos.x][curPos.y] == 0;
    }

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        ArrayHelper.print2DIntArray(board);
        KnightsTour kt = new KnightsTour();
        if(kt.isKnightTour(board)){
            System.out.println("Knight tour exist");
            ArrayHelper.print2DIntArray(board);
        } else {
            System.out.println("Knight tour DOES NOT exist");
            ArrayHelper.print2DIntArray(board);
        }
    }




}
