package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Merge_Intervals {

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start < o2.start) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		List<Interval> retList = new LinkedList<Interval>();
		Interval current = null;
		for (int i = 0; i < intervals.size(); i++) {
			if (current == null) {
				current = intervals.get(i);
				continue;
			} else {
				Interval newCome = intervals.get(i);
				if (current.end >= newCome.end) {
					continue;
				} else {
					if (current.end < newCome.start) {
						retList.add(current);
						current = newCome;
					} else {
						current.end = newCome.end;
					}
				}
			}
		}
		if (current != null) {
			retList.add(current);
		}
		return retList;
        
    }
	
	
	public static void main (String args[]) {
		
		//[1,3],[2,6],[8,10],[15,18]
		
		
//		Interval i1 = new Interval(2, 4);
//		Interval i2 = new Interval(1, 5);
//		Interval i3 = new Interval(6, 10);
//		Interval i4 = new Interval(11, 12);
//		Interval i5 = new Interval(8, 12);
		
		Interval i1 = new Interval(2, 6);
		Interval i2 = new Interval(1, 3);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		
		List<Interval> list = new LinkedList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		List<Interval> retList = merge(list);
		for (Interval i : retList) {
			System.out.println(i);
		}
	}
}

class Interval {
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

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
	
}