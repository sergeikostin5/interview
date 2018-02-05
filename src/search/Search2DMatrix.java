package search;

/**
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    For example,
    [
    [1,   3,  5,  7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
    ]
    Given target = 3, return true
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        return searchMatrix(matrix, target, 0, matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int row, int col){
        // Base case
        if(row >= matrix.length || col < 0) return false;

        // recursive step 1
        if(matrix[row][col] < target) return searchMatrix(matrix, target, row + 1, col);
        else if (matrix[row][col] > target) return searchMatrix(matrix, target, row, col - 1);
        else return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        Search2DMatrix sm = new Search2DMatrix();
        System.out.println(sm.searchMatrix(matrix,3));
    }



}
