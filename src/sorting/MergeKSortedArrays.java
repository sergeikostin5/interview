package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sergei.kostin on 12/27/17.
 */
public class MergeKSortedArrays {

    private static class Node{
        int row, col, value;

        Node(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public int[] mergeArrays(int[][] iarray){

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        for(int i = 0; i < iarray.length; i++){
            pq.add(new Node(i, 0, iarray[i][0]));
        }

        int[] result = new int[iarray.length * iarray[0].length];

        for(int i = 0; !pq.isEmpty(); i++){
            Node current = pq.poll();
            result[i] = current.value;
            if(current.col < iarray[current.row].length - 1){
                pq.add(new Node(current.row, current.col + 1, iarray[current.row][current.col + 1]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                        {1,3,5,7},
                        {2,4,6,8},
                        {0,9,10,11}
                        };

        MergeKSortedArrays ms = new MergeKSortedArrays();
        int[] result = ms.mergeArrays(arr);
        System.out.println(Arrays.toString(result));
    }
}
