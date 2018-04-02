package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sergei.kostin on 3/25/18.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int counter = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int[] result = new int[numCourses];

        for(int i = 0; i<prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }

        for(int i = 0; i<indegree.length; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            Integer cur = q.remove();
            result[counter] = cur;
            counter++;
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == cur){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] != 0) return new int[]{};
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,0}};
        CourseScheduleII cs = new CourseScheduleII();
        int[] result = cs.findOrder(2, arr);
        for(int i : result){
            System.out.println(i);
        }

    }

}
