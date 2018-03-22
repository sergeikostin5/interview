package arrays;

/**
 * Created by sergei.kostin on 3/9/18.
 */
public class FindCelebrity {

    int[][] arr = new int[2][2];

    public int findCelebrity(int n) {
        if(n < 2) return -1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j && j != n-1) continue;
                if(knows(i,j)) break;
                if(j == n-1 ){
                    if(checkCeleb(i, n)) return i;
                }
            }
        }
        return -1;
    }

    private boolean checkCeleb(int k, int n){
        for(int i = 0; i < n; i++){
            if(i==k) continue;
            if(!knows(i, k)) return false;
        }
        return true;
    }

    private boolean knows(int a, int b){
        arr[0][1] = 1;
        return arr[a][b] == 1;
    }

    public static void main(String[] args) {
        FindCelebrity fc = new FindCelebrity();
        System.out.println(fc.findCelebrity(2));
    }
}
