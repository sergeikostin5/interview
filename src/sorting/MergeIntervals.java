package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sergei.kostin on 3/16/18.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        if(intervals == null || intervals.size() <=1 ) return intervals;

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2 ){
                return o1.start - o2.start;
            }
        });

        for(int i = 0; i <intervals.size()-1;){
            int end1 = intervals.get(i).end;
            int start2 = intervals.get(i+1).start;
            // we have overlap if
            if(end1 >= start2){
                intervals.get(i+1).start = intervals.get(i).start;
                intervals.get(i+1).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
                intervals.remove(i);
            }else{
                i++;
            }
        }

        return intervals;

    }

    public static class Interval {
        int start;
        int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
  }

}
