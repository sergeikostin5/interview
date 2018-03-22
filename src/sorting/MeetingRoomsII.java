package sorting;

import java.util.Arrays;
import java.util.Comparator;
public class MeetingRoomsII {

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
        if(intervals == null || intervals.length == 0) return 0;


        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        } );

        int result = intervals.length;
        int currentEnd = intervals[0].end;
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i+1].start <= currentEnd ){
                result--;
            }
            currentEnd = Math.max(currentEnd, intervals[i+1].end);
        }

        return result;

    }

    public static void main(String[] args) {
        Interval elem1 = new Interval(5,8);
    }

}
