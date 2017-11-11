//package Algos;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * Definition for an interval. public class Interval { int start; int end;
// * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
// * e; } }
// */
//class FiveSix_Merge_Interval {
//	public List<Interval> merge(List<Interval> intervals) {
//
//		// whether the input is "right"
//		if (intervals.size() <= 1) {
//			return intervals;
//		}
//
//		// sort the sub intervals
//		intervals.sort((int1, int2) -> Integer.compare(int1.start, int2.start));
//
//		// sort the sub intervals without lamda -- selection sort -- time limit
//		// for(int i =0; i < intervals.size(); i++){
//		// int min = i;
//		// for(int k = i+1; k < intervals.size(); k++){
//		// if(intervals.get(k).start <= intervals.get(min).start){
//		// min = k;
//		// }
//		// }
//		// Interval tmpInterval = new
//		// Interval(intervals.get(min).start,intervals.get(min).end);
//		// intervals.get(min).start = intervals.get(i).start;
//		// intervals.get(min).end = intervals.get(i).end;
//		// intervals.get(i).start = tmpInterval.start;
//		// intervals.get(i).end = tmpInterval.end;
//		// }
//
//		// sort the sub intervals without lamda -- quickSort(List<Interval>
//		// intervals, int start, int end)
//		quickSort(intervals, 0, intervals.size() - 1);
//
//		List<Interval> result = new ArrayList<Interval>();
//
//		int start = intervals.get(0).start;
//		int end = intervals.get(0).end;
//
//		for (Interval inter : intervals) {
//			if (inter.start <= end) {
//				// if(end <= inter.end){
//				// end = inter.end;
//				// }
//				// call Math.max(a,b) to calculate the bigger one
//				end = Math.max(end, inter.end);
//
//				// compare this with a normal way
//
//				// if(inter.end > end){
//				// end = inter.end;
//				// }
//
//			} else {
//				result.add(new Interval(start, end));
//				start = inter.start;
//				end = inter.end;
//			}
//		}
//
//		// add the last interval
//		result.add(new Interval(start, end));
//
//		// return intervals;
//		return result;
//
//	}
//
//	public void quickSort(List<Interval> intervals, int start, int end) {
//		if (start < end) {
//			int q = partition(intervals, start, end);
//			quickSort(intervals, start, q - 1);
//			quickSort(intervals, q + 1, end);
//		}
//	}
//
//	public int partition(List<Interval> intervals, int start, int end) {
//
//		Interval tmp = new Interval(intervals.get(end).start, intervals.get(end).end);
//
//		int j = start - 1;
//
//		for (int i = start; i <= end - 1; i++) {
//			if (intervals.get(i).start <= tmp.start) {
//				j++;
//				Interval tmp1 = new Interval(intervals.get(j).start, intervals.get(j).end);
//				intervals.get(j).start = intervals.get(i).start;
//				intervals.get(j).end = intervals.get(i).end;
//				intervals.get(i).start = tmp1.start;
//				intervals.get(i).end = tmp1.end;
//
//			}
//		}
//
//		Interval tmp2 = new Interval(intervals.get(j + 1).start, intervals.get(j + 1).end);
//		intervals.get(j + 1).start = tmp.start;
//		intervals.get(j + 1).end = tmp.end;
//		intervals.get(end).start = tmp2.start;
//		intervals.get(end).end = tmp2.end;
//
//		return j + 1;
//	}
//
//}