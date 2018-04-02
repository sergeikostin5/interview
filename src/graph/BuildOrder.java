package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
    Given a list of packages that need to be built and the dependencies for each package, determine a valid order in
    which to build the packages
 **/
public class BuildOrder {

    public List<Integer> getOrder(int n, int[][] dependencies){
        List<Integer> result = new LinkedList<>();

        int[] indegree = new int[n];

        //                       0 1 1 3 4
        // build indegree array {0,1,1,2,1}
        for(int row = 0; row < dependencies.length; row++){
            System.out.println(dependencies[row][0]);
            indegree[dependencies[row][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()){
            Integer cur = queue.remove();
            result.add(cur);
            for(int i = 0; i < dependencies.length; i++){
                if(dependencies[i][1] == cur){
                    indegree[dependencies[i][0]]--;
                    if(indegree[dependencies[i][0]] == 0){
                        queue.add(dependencies[i][0]);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BuildOrder bo = new BuildOrder();
        int[][] arr = { {1,0},
                        {2,0},
                        {3,1},
                        {3,2},
                        {4,3}};
        List<Integer> list = bo.getOrder(5, arr);
        System.out.println(list);
    }

}
