package com.interviewbit.arrays;

/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
Make sure the returned intervals are also sorted.
 */

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals obj = new MergeIntervals();
        ArrayList<Interval> list = new ArrayList<>();

        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));
        Interval newInterval = new Interval(4, 9);
        ArrayList<Interval> result = obj.insert(list, newInterval);
        System.out.println(result);

    }

    public ArrayList<Interval> insert(ArrayList<Interval> list, Interval intervalToMerge) {

        int i = 0;
        while (i < list.size()) {
            Interval currentInterval = list.get(i);
            if (currentInterval.end < intervalToMerge.start) {
                i++;
            } else if (currentInterval.start > intervalToMerge.end) {
                list.add(i, intervalToMerge);
                break;
            } else {
                intervalToMerge.start = Math.min(intervalToMerge.start, currentInterval.start);
                intervalToMerge.end = Math.max(intervalToMerge.end, currentInterval.end);
                list.remove(i);
            }
        }

        if (i == list.size()) {
            list.add(intervalToMerge);
        }

        return list;
    }


    public boolean isOverlapping(Interval a, Interval b) {
        return Math.max(a.start, b.start) < Math.min(a.end, b.end);
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
    The Question seems overwhelming but it is easy
    if you take baby steps.


    See in the first if condition we are checking if the current interval comes before
    the intervals to be merged. ( curr.end < intervalToMerge.start)
        So in that case we will move to the next interval.

    end the send else if condition we are checking if the intervalToMerge comes after
    the current interval ( curr.start > intervalToMerge.end)
        In this case we will just insert the intervalToMerge in the current position and break.

    in the else part we are doing tricky things.
    Here is where the intervals overlaps.
    intervalToMerge overlaps with currentIntervals.
    We are storing the result of the merge in the intervalToMerge and deleting the current
    interval.
    Result means the min and max of the start and end respectively.

    The condition after the loop to add the intervalToMerge in result is because
    we are iterating in the loop in dynamic way. See we are taking list.size()
    and the size of the list may decrease so may be we are at last interval and
    it overlaps with the interval to merge so we deleted that interval and
    are storing the result in the intervalToMerge
    now in that case we will need to add the intervalToMerge back in the result right.
    So there is nothing in there to worry in this question as well.




 */