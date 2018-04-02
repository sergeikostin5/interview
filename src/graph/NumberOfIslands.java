package graph;

import java.util.HashMap;

/**
 * Created by sergei.kostin on 2/6/18.
 */
public class NumberOfIslands {

    private static class DisjointSet{

        public int count = 0;
        private HashMap<Point, Node> map = new HashMap<>();

        private class Node{

            Node parent;
            Point data;
            int rank;

            Node(Point data){
                this.data = data;
            }
        }

        public void makeSet(Point point){
            Node node = new Node(point);
            node.parent = node;
            node.rank = 0;
            map.put(point, node);
            count++;
        }


        private Node findSet(Node node){
            Node parent = node.parent;
            if(parent == node) return parent;
            node.parent = findSet(node.parent);
            return node.parent;
        }

        public boolean union(Point p1, Point p2){
            Node node1 = map.get(p1);
            Node node2 = map.get(p2);

            Node parent1 = findSet(node1);
            Node parent2 = findSet(node2);

            if(parent1.data.equals(parent2.data)) return false;

            if(parent1.rank >= parent2.rank){
                parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
                parent2.parent = parent1;
            } else {
                parent1.parent = parent2;
            }
            count--;
            return true;
        }

    }

    private static class Point{

        int x, y;

        Point(int x, int y){
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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public int numIslands(char[][] grid) {
        DisjointSet ds = new DisjointSet();
        if(grid.length == 0) return 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    Point point1 = new Point(i, j);
                    if(!ds.map.containsKey(point1))ds.makeSet(point1);
                    if((i+1) < grid.length && grid[i+1][j] == '1'){
                        Point point2 = new Point(i+1, j);
                        if(!ds.map.containsKey(point2)) ds.makeSet(point2);
                        ds.union(point1, point2);
                    }
                    if((j+1) < grid[0].length && grid[i][j+1] == '1'){
                        Point point2 = new Point(i, j+1);
                        if(!ds.map.containsKey(point2)) ds.makeSet(point2);
                        ds.union(point1, point2);
                    }
                }
            }
        }

        return ds.count;
    }

    public static void main(String[] args) {
        char[][] arr = new char[3][5];
        arr[0][0] = '1';
        arr[0][2] = '1';
        arr[0][3] = '1';
        arr[0][4] = '1';
        arr[1][0] = '1';
        arr[1][2] = '1';
        arr[1][4] = '1';
        arr[2][0] = '1';
        arr[2][1] = '1';
        arr[2][2] = '1';
        arr[2][4] = '1';

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(arr));
    }





}
