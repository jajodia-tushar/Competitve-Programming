package com.leetcode.junechallenge;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
You are given two integers n and k and two integer arrays speed and efficiency both of length n.
There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and
efficiency of the ith engineer respectively.
Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among
their engineers.

Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.



Example 1:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
Output: 60
Explanation:
We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
Example 2:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
Output: 68
Explanation:
This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
Example 3:

Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
Output: 72
 */


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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long totalSpeed = 0, best = 0;
        for (int[] pair : ord) {
            int spd = pair[1];
            queue.add(spd);
            if (queue.size() <= k) totalSpeed += spd;
            else totalSpeed += spd - queue.poll();
            best = Math.max(best, totalSpeed * pair[0]);
        }
        return (int) (best % 1000000007);
    }

}


/*
    This One is good one.
    See we have two parameters.
    One is speed and one is Efficiency.
    We need maximum in both the cases.
    One can be achieved by sorting in descending order[ We do it for efficiency]

    And the other one will be taken care by the PriorityQueue(PQ)
    You are only allowed to choose k items.

    See you start by taking high efficiency engineers till K.
    And you add the individual speed in PQ and sum the totalSpeed
    So Far as well.

    At any point in time while you are iterating the array if
    you want to calculate the efficiency then you can do
    totalSpeed * current Efficiency, Because see,
    You have sorted in reverse order so the efficiency and you will always be minimum
    efficiency all the time.

    Now if you cross the K length while traversing you will have to leave some engineers.
    Here the PQ comes into play.
    You poll from the PQ and it will pop the low Speed Engineer.

 */
