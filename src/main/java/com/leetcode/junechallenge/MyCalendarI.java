package com.leetcode.junechallenge;

import java.util.Map;
import java.util.TreeMap;


/*
You are implementing a program to use as your calendar. We can add a new event if adding the event
will not cause a double booking.
A double booking happens when two events have some non-empty intersection
(i.e., some moment is common to both events.).
The event can be represented as a pair of integers start and end that represents a booking
on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:
MyCalendar() Initializes the calendar object.
boolean book(int start, int end) Returns true if the event can be added to the calendar successfullywithout causing a double booking. Otherwise, return false and do not add the event to the calendar.

Example 1:
Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.


Constraints:

0 <= start < end <= 109
At most 1000 calls will be made to book.
 */

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