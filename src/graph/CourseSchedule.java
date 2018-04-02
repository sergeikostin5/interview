package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sergei.kostin on 3/25/18.
 */
public class CourseSchedule {

    public boolean isValid(int n, int[][] dependencies){

        int[] indegree = new int[n];

        //                       0 1 1 3 4
        // build indegree array {0,1,1,2,1}
        for(int row = 0; row < dependencies.length; row++){
            indegree[dependencies[row][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            Integer cur = queue.remove();
            for(int i = 0; i < dependencies.length; i++){
                if(dependencies[i][1] == cur){
                    indegree[dependencies[i][0]]--;
                    if(indegree[dependencies[i][0]] == 0){
                        queue.add(dependencies[i][0]);
                    }
                }
            }
        }

        for(int i = 0; i < dependencies.length; i++){
            if(indegree[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] arr = { {1,0},
                {2,0},
                {3,1},
                {3,2},
                {4,3},
                {3,4}};
        boolean res = cs.isValid(5, arr);
        System.out.println(res);
    }

}
