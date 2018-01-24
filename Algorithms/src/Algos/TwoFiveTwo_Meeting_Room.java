package Algos;

import java.util.Arrays;
import java.util.Comparator;

public class TwoFiveTwo_Meeting_Room {
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

    public static boolean canAttendMeetings(Interval[] intervals) {
//        Arrays.sort(intervals, (o1, o2) -> o1.start - o2.start);

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int i = 0;
        for (int k = 1; k < intervals.length; k++) {
            if (intervals[i].end > intervals[k].start) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}
