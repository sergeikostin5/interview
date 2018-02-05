package recursion;

/**
 * Created by sergei.kostin on 12/29/17.
 */
public class CountPath {

    public int countPath(int[][] board){
        return countPath(board, 0, 0);
    }

    private int countPath(int[][] board, int row, int col){
        if(row == board.length) return 0;
        if(col == board[0].length) return 0;
        if(board[row][col] == 1) return 0;
        if(row == board.length - 1 && col == board[0].length - 1) return 1;

        int right = countPath(board, row, col+1);
        int down = countPath(board, row+1, col);
        return right+down;
    }


    public static void main(String[] args) {
        int[][] arr = new int[4][3];
        arr[1][1] = 1;
        arr[2][1] = 1;
        CountPath cp = new CountPath();
        System.out.println(cp.countPath(arr));
    }
}
