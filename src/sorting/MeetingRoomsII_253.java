package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/meeting-rooms-ii/description/
public class MeetingRoomsII_253 {

      private static class Interval {
          int start;
          int end;

          Interval() {
              start = 0;
              end = 0;
          }

          Interval(int s, int e) {
              start = s;
              end = e;
          }
      }


    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        Queue<Integer> minHeap = new PriorityQueue<>();

        for(Interval i : intervals){
            if(minHeap.isEmpty() || i.start < minHeap.peek()){
                minHeap.add(i.end);
            }else{
                minHeap.poll();
                minHeap.add(i.end);
            }
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        Interval elem1 = new Interval(5,8);
    }

}
