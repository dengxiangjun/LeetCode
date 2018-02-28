import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p/>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p/>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p/>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p/>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(0, 1));
//        intervals.add(new Interval(3, 5));
//        intervals.add(new Interval(6, 7));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(12, 16));

        List<Interval> res = insert(intervals, new Interval(1, 5));
        System.out.println(res);
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null) return res;
        if (intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) res.add(intervals.get(i++));
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) res.add(intervals.get(i++));
        return res;
    }

    public static class Interval {
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
}
