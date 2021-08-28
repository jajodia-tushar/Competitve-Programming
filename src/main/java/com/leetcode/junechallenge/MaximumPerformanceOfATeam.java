package com.leetcode.junechallenge;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {

    public static void main(String[] args) {

        MaximumPerformanceOfATeam obj = new MaximumPerformanceOfATeam();
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        int n = speed.length;
//        int[][] mix = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            mix[i] = new int[]{efficiency[i], speed[i]};
//        }
//
//        Arrays.sort(mix, (a, b) -> Integer.compare(b[0], a[0]));
//        ArrayUtils.printArray(mix);

        int result = obj.maxPerformance(n, speed, efficiency, k);
        System.out.println(result);


    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] mix = new int[n][2];
        for (int i = 0; i < n; i++) {
            mix[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(mix, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        int totalSpeed = 0;
        long result = 0;

        for (int[] pair : mix) {

            queue.add(pair[1]);
            if (queue.size() <= k) {
                totalSpeed += pair[1];
            } else {
                totalSpeed += pair[1] - queue.poll();
            }
            result = Math.max(result, totalSpeed * pair[0]);
        }

        return (int) (result % 1000000007);


    }

    public int maxPerformanceX(int n, int[] speed, int[] efficiency, int k) {
        int[][] ord = new int[n][2];
        for (int i = 0; i < n; i++)
            ord[i] = new int[]{efficiency[i], speed[i]};
        Arrays.sort(ord, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> sppq = new PriorityQueue<>();
        long totalSpeed = 0, best = 0;
        for (int[] pair : ord) {
            int spd = pair[1];
            sppq.add(spd);
            if (sppq.size() <= k) totalSpeed += spd;
            else totalSpeed += spd - sppq.poll();
            best = Math.max(best, totalSpeed * pair[0]);
        }
        return (int) (best % 1000000007);
    }

}
