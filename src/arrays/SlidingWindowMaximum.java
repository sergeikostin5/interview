package arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum/description/
 */
public class SlidingWindowMaximum {

    public static int[] windowMax(int [] array, int width) {
        Deque<Integer> doubleQueue = new LinkedList<Integer>();
        //calculate the first window max
        int [] maxArray = new int[array.length - width + 1];
        for (int i = 0; i < width; i++) {
            while(!doubleQueue.isEmpty() && array[i] > doubleQueue.peekLast())
                doubleQueue.removeLast();
            doubleQueue.push(array[i]);
        }
        maxArray[0] = doubleQueue.peekFirst();
        //then try to move the window right and pop
        for (int i = width; i < array.length; i++) {
            if (doubleQueue.size() == width) // if full, remove the first max element
                doubleQueue.removeFirst();
            while(!doubleQueue.isEmpty() && array[i] > doubleQueue.peekLast())
                doubleQueue.removeLast();
            doubleQueue.addLast(array[i]);
            maxArray[i-width+1] = doubleQueue.peekFirst(); // first element will be the max;
        }
        return maxArray;
    }

    public static void main(String[] args) {

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(1);
        q.push(0);
        q.push(-1);
        System.out.println(q);
    }
}
