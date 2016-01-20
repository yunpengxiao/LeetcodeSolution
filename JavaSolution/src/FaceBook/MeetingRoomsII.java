package FaceBook;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xyunpeng on 1/19/16.
 */
public class MeetingRoomsII {
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalComparator());

        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.end - b.end; }
        });

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval in = heap.poll();

            if (intervals[i].start >= in.end) {
                in.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(in);
        }

        return heap.size();
    }
}


//参考了别人家的代码,思维很巧妙: https://leetcode.com/discuss/50911/ac-java-solution-using-min-heap
//还有一种有意思的方法:         https://leetcode.com/discuss/70998/java-ac-solution-greedy-beats-92-03%25