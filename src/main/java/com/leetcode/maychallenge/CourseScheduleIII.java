package com.leetcode.maychallenge;


import java.util.Arrays;
import java.util.PriorityQueue;

/*
There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.

Return the maximum number of courses that you can take.
 */
public class CourseScheduleIII {

    public static void main(String[] args) {
        CourseScheduleIII obj = new CourseScheduleIII();
        int[][] ints = {{3, 2}, {4, 3}};
        int result = obj.scheduleCourse(ints);
        System.out.println(result);
    }


    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]) == 0 ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = courses.length;
        int time = 0;

        for (int i = 0; i < n; i++) {
            if (courses[i][0] + time <= courses[i][1]) {
                time += courses[i][0];
                queue.add(courses[i][0]);
            } else if (queue.size() > 0 && queue.peek() > courses[i][0]) {
                time += courses[i][0] - queue.poll();
                queue.add(courses[i][0]);

            }
        }

        return queue.size();
    }
}