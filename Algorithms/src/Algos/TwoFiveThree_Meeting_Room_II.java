package Algos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoFiveThree_Meeting_Room_II {

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

        if (intervals.length <= 1) {
            return intervals.length;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        // priorityqueue.offer(): time complexity O (logn)
        pq.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // priorityqueue.poll(): time complexity O(logn)
            Interval inter = pq.poll();

            if (inter.end <= intervals[i].start) {
                inter.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }

            pq.offer(inter);
        }

        return pq.size();

//         int prevStart = intervals[0].start;
//         int prevEnd = intervals[0].end;
//         List<Interval> l = new ArrayList<>();

//         for(int k = 1; k < intervals.length; k++){

//             int start = intervals[k].start;
//             int end = intervals[k].end;

//             if(prevEnd > start ){

//                 for(int z = 0; z < l.size(); z++){
//                     if(l.get(z).end <= prevStart){
//                         l.remove(z);
//                         break;
//                     }
//                 }

//                 l.add(new Interval(prevStart,prevEnd));

//                 prevStart = start;
//                 prevEnd = end;
//             }else{
//                 prevEnd = end;
//             }

//         }

//        for(int tt = 0; tt < l.size(); tt++){
//             if(l.get(tt).end <= prevStart){
//                 l.remove(tt);
//                 break;
//             }
//         }

//         l.add(new Interval(prevStart, prevEnd));


//         return l.size();
    }
}
