package com.interviewbit.greedy;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRooms {

    public static void main(String[] args) {

        MeetingRooms obj = new MeetingRooms();
        int[][] ints = {{0, 14}, {6, 25}, {12, 19}, {13, 19}, {5, 9}};
        int result = obj.solveOptimized(ints);
        System.out.println(result);
        ArrayUtils.printArray(ints);
        ;
    }

    public int solve(int[][] A) {
        int n = A.length;
        Arrays.sort(A, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> timeToLeaveRoot = new PriorityQueue<>();
        int numberOfMeetingRooms = 0;
        int meetingRoomsFreeNow = 0;

        for (int i = 0; i < n; i++) {

            if (!timeToLeaveRoot.isEmpty()) {
                int nextTimeFree = timeToLeaveRoot.peek();
                if (nextTimeFree <= A[i][0]) {
                    meetingRoomsFreeNow++;
                    timeToLeaveRoot.poll();
                }
            }
            if (meetingRoomsFreeNow == 0) {
                numberOfMeetingRooms++;
            } else {
                meetingRoomsFreeNow--;
            }
            timeToLeaveRoot.add(A[i][1]);
        }
        return numberOfMeetingRooms;
    }

    public int solveOptimized(int[][] A) {

        int n = A.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = A[i][0];
            end[i] = A[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0;
        int endPointer = 0;
        int count = 0;

        while (startPointer < n && endPointer < n) {

            if (start[startPointer] < end[endPointer]) {
                count++;
            } else {
                endPointer++;
            }
            startPointer++;
        }
        return count;
    }
}
