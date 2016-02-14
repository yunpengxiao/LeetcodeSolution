package Google;

/**
 * Created by xyunpeng on 2/14/16.
 */
public class MergeIntervals {
    public class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, new IntervalComparator());
        Interval last = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (last.end < intervals.get(i).start) {
                result.add(last);
                last = new Interval(intervals.get(i).start, intervals.get(i).end);
            } else {
                last.end = Math.max(last.end, intervals.get(i).end);
            }
        }
        result.add(last);
        return result;
    }
}
