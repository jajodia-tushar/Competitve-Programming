package com.interviewbit.week19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {

    public static void main(String[] args) {

        MergeInterval obj = new MergeInterval();
        ArrayList<Interval> lists = new ArrayList<>();
        lists.add(new Interval(1,10));
        lists.add(new Interval(2,9));
        lists.add(new Interval(3,8));
        lists.add(new Interval(4,7));
        lists.add(new Interval(5,6));
        lists.add(new Interval(6,6));

        Interval interval = new Interval(4, 9);
        int[] arr = {29, 54, 75, 56, 60, 61, 86, 22, 43, 56, 87, 32, 53, 14, 81, 64, 65, 9, 42, 12, 33, 22, 58, 84, 90, 27, 59, 41, 48, 43, 47, 22, 29, 16, 23, 41, 72, 15, 87, 20, 59, 45, 84, 14, 77, 72, 93, 20, 58, 47, 53, 25, 88, 5, 89, 34, 97, 14, 47};
        System.out.println(obj.merge(obj.makeQuestionInput(arr)));


    }

    public ArrayList<Interval> makeQuestionInput(int[] data){

        int size = data[0] * 2;
        ArrayList<Interval> lists = new ArrayList<>();
        for(int i = 0; i < size; i += 2){
            lists.add(new Interval(data[i+1],data[i+2]));
        }
        return lists;
    }


    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){


        if(newInterval.end < intervals.get(0).start){
            intervals.add(0,newInterval);
            return intervals;
        }
        boolean isDoneFirstTime = false;
        for(int i = 0; i < intervals.size(); i++){
            Interval item = intervals.get(i);
            if(isOverlapping(item,newInterval)){
                if(isDoneFirstTime){
                    item.start = Math.min(item.start,newInterval.start);
                    item.end = Math.max(item.end,newInterval.end);
                    newInterval = item;
                    intervals.remove(i - 1);
                    i--;
                }
                else{
                    isDoneFirstTime = true;
                    item.start = Math.min(item.start,newInterval.start);
                    item.end = Math.max(item.end,newInterval.end);
                    newInterval = item;
                }
            }
        }

        if(newInterval.start > intervals.get(intervals.size() - 1).end){
            intervals.add(newInterval);
            return intervals;
        }

        return intervals;
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort( intervals, Comparator.comparing(a -> a.start));

        int i = 0;
        while( i < (intervals.size() - 1)){
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1);
            if(isOverlapping(current,next)){
                next.start = Math.min(current.start,next.start);
                next.end = Math.max(current.end,next.end);
                intervals.remove(i);
            }
            else{
                i++;
            }
        }

        return intervals;

    }


    public boolean isOverlapping(Interval a, Interval b){
        if( a.start == a.end ){
            return b.start < a.start && b.end > a.start;
        }

        if( b.start == b.end ){
            return a.start < b.start && a.end > b.start;
        }
        return Math.max(a.start,b.start) < Math.min(a.end,b.end);
    }
}

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
