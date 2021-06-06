package com.leetcode.junechallenge;

import java.util.Arrays;

/*
Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.



Example 1:



Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:



Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9


Constraints:

2 <= h, w <= 10^9
1 <= horizontalCuts.length < min(h, 10^5)
1 <= verticalCuts.length < min(w, 10^5)
1 <= horizontalCuts[i] < h
1 <= verticalCuts[i] < w
It is guaranteed that all elements in horizontalCuts are distinct.
It is guaranteed that all elements in verticalCuts are distinct.

 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static void main(String[] args) {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts obj = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

        int[] hc = {1, 2, 4};
        int[] vc = {1, 3};
        int result = obj.maxArea(5, 4, hc, vc);
        System.out.println(result);
    }


    public int maxArea(int h, int w, int[] hc, int[] vc) {

        int wMax = getMaximumGap(vc, w);
        int hMax = getMaximumGap(hc, h);

        return (int) (((long) wMax * (long) hMax) % 1000000007);


    }

    public int getMaximumGap(int[] arr, int endValue) {

        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        float gap = (float) (max - min) / (float) (n - 1);

        int[] maxBucket = new int[n];
        int[] minBucket = new int[n];

        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int bucketIndex = (int) Math.floor((curr - min) / gap);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], curr);
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], curr);
        }

        int preMin = Integer.MIN_VALUE;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            if (preMin != Integer.MIN_VALUE && minBucket[i] != Integer.MAX_VALUE) {
                maxDiff = Math.max(maxDiff, minBucket[i] - preMin);
            }

            if (maxBucket[i] != Integer.MIN_VALUE) {
                preMin = maxBucket[i];
            }
        }

        maxDiff = Math.max(min, maxDiff);
        maxDiff = Math.max(endValue - max, maxDiff);

        return maxDiff;
    }

    public int maxAreaNotOptimized(int h, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);
        int maxh = Math.max(hc[0], h - hc[hc.length - 1]),
                maxv = Math.max(vc[0], w - vc[vc.length - 1]);
        for (int i = 1; i < hc.length; i++)
            maxh = Math.max(maxh, hc[i] - hc[i - 1]);
        for (int i = 1; i < vc.length; i++)
            maxv = Math.max(maxv, vc[i] - vc[i - 1]);
        return (int) ((long) maxh * maxv % 1000000007);
    }
}
/*
     The Simple Solution is sort the array and find the maximum gaps between sorted elements
     for width and heights
     return the product.
     But the time Complexity is nlogn + mlogm.
     You can use the idea of previous question is MaxConsecutiveGap to improve the time.
 */