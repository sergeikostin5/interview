package arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/smallest-range/description/
 */
public class SmallestRange {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Wrapper> minHeap = new PriorityQueue<>(new Comparator<Wrapper>(){
            @Override
            public int compare(Wrapper o1, Wrapper o2) {
                return o1.value - o2.value;
            }
        });

        int max = nums.get(0).get(0);
        for(int i=0; i<nums.size(); i++) {
            minHeap.add(new Wrapper(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }

        int minRange = Integer.MAX_VALUE;
        int start = -1;
        while(minHeap.size() == nums.size()) {
            Wrapper t = minHeap.remove();
            if(max - t.value < minRange) {
                // We found new min range, update minRange and start
                minRange = max - t.value;
                start = t.value;
            }

            if(t.index+1 < nums.get(t.listNum).size()) {
                // if not last index in given list create new Wrapper instance with next elem in a list and add it to pq
                Wrapper w = new Wrapper(nums.get(t.listNum).get(t.index+1), t.listNum, t.index+1);
                minHeap.add(w);
                max = Math.max(max, w.value);
            }
        }
        return new int[]{start, start+minRange};
    }

    private static class Wrapper {
        int value;
        int listNum;
        int index;

        Wrapper(int value, int listNum, int index) {
            this.value = value;
            this.listNum = listNum;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,10,15,24,26};
        int[] arr2 = {0,9,12,20};
        int[] arr3 = {5,18,22,30};
        List<Integer> list1 = new ArrayList<>();
        for(int i : arr1){
            list1.add(i);
        }
        List<Integer> list2 = new ArrayList<>();
        for(int i : arr2){
            list2.add(i);
        }
        List<Integer> list3 = new ArrayList<>();
        for(int i : arr3){
            list3.add(i);
        }
        List<List<Integer>> temp = new ArrayList<>();
        temp.add(list1);
        temp.add(list2);
        temp.add(list3);

        SmallestRange sr = new SmallestRange();
        int[] arr = sr.smallestRange(temp);
        System.out.println(Arrays.toString(arr));
    }
}
