package Google;

/**
 * Created by xyunpeng on 2/14/16.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        int length = intervals.size();
        //Interval last = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 0; i < length; i++) {
            if (newInterval.start <= intervals.get(i).start) {
                intervals.add(i, newInterval);
                break;
            }
        }

        if (intervals.size() == length) {
            intervals.add(newInterval);
        }

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
