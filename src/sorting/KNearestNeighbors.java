package sorting;

import java.util.*;

/**
 * HackerRank Interview Kickstart
 * Given a point P and other N points in two dimensional space, find K points out of the N points which are nearest to P.
 *
 * https://stackoverflow.com/questions/20398799/find-k-nearest-points-to-point-p-in-2-dimensional-plane
 */
public class KNearestNeighbors {

    private static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            return this.distance - o.distance;
        }
    }

    // Solution 1 with O(N*Log(K)) using binary heap
    public List<Point> getKNearestPoints(Point[] arr, Point center, int k){

        // Max oriented Priority Queue, descending order
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p2.distance - p1.distance ;
            }
        });

        for(Point elem : arr){
            elem.distance = getDistance(elem, center);
            if(pq.size() < k){
                pq.add(elem);
            } else {
                if(elem.distance < pq.peek().distance){
                    pq.poll();
                    pq.add(elem);
                }
            }
        }

        return new ArrayList<>(pq);

    }

    // Solution 2 with O(N) preferred during interview
    public List<Point> getKNearestPointsQuick(Point[] arr, Point center, int k){
        List<Point> result = new LinkedList<>();
        return getKNearestPointsQuick(arr, center, k, 0, arr.length - 1, result);
    }

    public List<Point> getKNearestPointsQuick(Point[] arr, Point center, int k, int left, int right, List<Point> result){


        int pivot = partition(arr, left, right);

        if(pivot == k){
            for(int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if( pivot > k){
            return getKNearestPointsQuick(arr, center, k, 0, pivot - 1, result);
        } else {
            return getKNearestPointsQuick(arr, center, k, pivot + 1, right, result);
        }
    }

    private int partition(Point[] arr, int left, int right){
        int pivot = left;
        int i = left;
        int j = right;
        while(i < j){
            while( arr[i].compareTo(arr[pivot]) < 0){
                i++;
            }
            while(arr[j].compareTo(arr[pivot])> 0){
                j--;
            }
            if(arr[i].compareTo(arr[j]) > 0 && i<j){
                swap(arr, i, j);
            }
        }
        if(arr[pivot].compareTo(arr[j]) > 0){
            swap(arr, j, pivot);
        }
        return j;
    }

    private void swap(Point[] arr, int i, int j){
        Point temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private int getDistance(Point point, Point center){
        return (point.x - center.x)*(point.x - center.x) + (point.y - center.y)*(point.y - center.y);
    }

    public static void main(String[] args) {
        Point center = new Point(3,4);
        Point[] arr = {new Point(6,6), new Point(2,2), new Point(3,3), new Point(-1,-1), new Point(9,8),
                new Point(3,4), new Point(4,3)};
        KNearestNeighbors kNearest = new KNearestNeighbors();
        List<Point> list = kNearest.getKNearestPoints(arr, center, 3);
        for(Point p : list){
            System.out.println(p);
        }
        System.out.println("End");

        list = kNearest.getKNearestPointsQuick(arr, center, 3);
        for(Point p : list){
            System.out.println(p);
        }

    }



}
