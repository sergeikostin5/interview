package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergei.kostin on 3/25/18.
 */
public class FriendsCircle_547 {

    private static class DisjointSet{

        int count = 0;
        Map<Point, Node> map = new HashMap<>();

        class Node{
            Point point;
            int rank;
            Node parent;
        }

        Node findParent(Node node){
            Node parent = node.parent;
            if(parent == node) return parent;
            node.parent = findParent(node.parent);
            return node.parent;
        }

        boolean union(Point p1, Point p2){
            Node node1 = map.get(p1);
            Node node2 = map.get(p2);

            Node parent1 = findParent(node1);
            Node parent2 = findParent(node2);

            if(parent1.equals(parent2)) return false;

            if(parent1.rank >= parent2.rank){
                if(parent1.rank == parent2.rank) parent1.rank++;
                parent2.parent = parent1;
            }else{
                parent1.parent = parent2;
            }
            count--;
            return true;
        }

        void makeSet(Point point){
            Node node = new Node();
            node.point = point;
            node.parent = node;
            node.rank = 0;
            map.put(point, node);
            count++;
        }
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public int findCircleNum(int[][] M){
        DisjointSet ds = new DisjointSet();

        for(int row = 0; row < M.length; row++ ){
            for(int col = 0; col < M[0].length; col++){
                if(M[row][col] != 1) continue;
                Point point1 = new Point(row, col);
                if(!ds.map.containsKey(point1)) ds.makeSet(point1);
                if(row+1 < M.length){
                    if(M[row+1][col] == 1){
                        Point point2 = new Point(row+1, col);
                        if(!ds.map.containsKey(point2)) ds.makeSet(point2);
                        ds.union(point1, point2);
                    }
                }
                if(col+1 < M[0].length){
                    if(M[row][col+1] == 1){
                        Point point2 = new Point(row, col+1);
                        if(!ds.map.containsKey(point2)) ds.makeSet(point2);
                        ds.union(point1, point2);
                    }
                }
            }
        }
        return ds.count;
    }

    public static void main(String[] args) {

        FriendsCircle_547 fs = new FriendsCircle_547();
        int[][] grid = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        System.out.println(fs.findCircleNum(grid));

    }
}
