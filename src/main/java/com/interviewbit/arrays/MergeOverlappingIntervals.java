package com.interviewbit.arrays;

/*
    Given a collection of intervals, merge all overlapping intervals.
    For example:
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
    Make sure the returned intervals are sorted.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        MergeOverlappingIntervals obj = new MergeOverlappingIntervals();

//        (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 10));
        list.add(new Interval(2, 9));
        list.add(new Interval(3, 8));
        list.add(new Interval(4, 7));
        list.add(new Interval(5, 6));
        list.add(new Interval(6, 6));

        ArrayList<Interval> result = obj.merge(list);
        System.out.println(result);

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, Comparator.comparing(a -> a.start));
        int i = 0;
        while (i < intervals.size() - 1) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i + 1);

            if (Math.max(curr.start, next.start) <= Math.min(curr.end, next.end)) {
                curr.start = Math.min(curr.start, next.start);
                curr.end = Math.max(curr.end, next.end);
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        return intervals;
    }

    static class Interval {
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
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}

/*
    This one is really simple.
    Take two interval curr and next
    and if they overlap

    just store the result in the curr and delete the next node.

    It will just do.
 */