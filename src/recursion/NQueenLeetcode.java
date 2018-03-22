package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sergei.kostin on 3/13/18.
 */
public class NQueenLeetcode {

    public List<List<String>> solveNQueens(int n) {
        Position[] resultPos = new Position[n];
        int[][] arr = new int[n][n];
        List<List<String>> resultList = new ArrayList<>();
        findQueens(0, arr, resultPos, resultList);
        return resultList;
    }

    private class Position{
        int x, y, diag1, diag2;

        Position(int x, int y){
            this.x = x;
            this.y = y;
            diag1 = x - y;
            diag2 = x + y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private void findQueens(int curRow, int[][] arr, Position[] resultPos, List<List<String>> listResult){
        if(curRow == arr.length ) {
            System.out.println(Arrays.toString(resultPos));
            StringBuilder builder = new StringBuilder();
            List<String> list = new ArrayList<>();
            for(int row = 0; row < resultPos.length; row++){
                for(int col = 0; col < arr.length; col++){
                    if(row == resultPos[row].x && col == resultPos[row].y) builder.append('Q');
                    else builder.append('.');
                }
                list.add(builder.toString());
                builder = new StringBuilder();
            }
            listResult.add(list);
            return;
        }
        for(int col = 0; col < arr.length; col++){
            Position newPos = new Position(curRow, col);
            if(!isAttacked(newPos, resultPos)){
                resultPos[curRow] = newPos;
                findQueens(curRow+1, arr, resultPos, listResult);
                resultPos[curRow] = null;
            }
        }
        return;
    }

    private boolean isAttacked(Position cur, Position[] positions){
        for(Position p : positions){
            if(p != null && (p.x == cur.x || p.y == cur.y || p.diag1 == cur.diag1 || p.diag2 == cur.diag2)) return true;
        }
        return false;
    }
}
