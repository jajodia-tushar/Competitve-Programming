package com.leetcode.junechallenge;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {

    public static void main(String[] args) {

        MyCalendarI obj = new MyCalendarI();
        System.out.println(obj.book(100, 200));
        System.out.println(obj.book(80, 150));

    }

    TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public MyCalendarI() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }

    public boolean bookX(int start, int end) {
        Integer nextKey = calendar.ceilingKey(start);
        Integer preKey = calendar.floorKey(start);

        if ((nextKey == null || end <= nextKey) &&
                (preKey == null || calendar.get(preKey) <= start)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/*
    Both the method will solve this question perfectly.
    But there is just a small optimization in the first Solution.

    If we store the values as end,start and we query
    as calendar.higherEntry(start)
    The event will be picked up in a manner where we don't need to test
    for the pre condition
    because the pre will end will already be less than my current start.
    So no issues.

 */