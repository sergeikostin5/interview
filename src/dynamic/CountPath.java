package dynamic;

/**
 * Created by sergei.kostin on 1/31/18.
 */
public class CountPath {

    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1) return 0;
        int[][] map = new int[m+1][n+1];
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<m+1; j++){
                map[j][i] = -1;
            }
        }
        map[1][1] = 1;
        map[0][0] = 0;
        map[0][1] = 0;
        map[1][0] = 0;
        return uniquePaths(m, n, map);
    }

    private int uniquePaths(int m, int n, int[][] map){
        if(m<1 || n<1) return 0;
        if(map[m][n] > -1){
            return map[m][n];
        }
        int n1 = uniquePaths(m-1, n, map);
        int n2 = uniquePaths(m, n-1, map);
        int result = n1+n2;
        map[m][n] = result;
        return map[m][n];
    }

    public static void main(String[] args) {
        CountPath cp = new CountPath();
        System.out.println(cp.uniquePaths(1,2));
    }

}
