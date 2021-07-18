package com.leetcode.julychallenge;

import com.interviewbit.utils.ArrayUtils;

/*
You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such that all of these parts represent the same binary value.

If it is possible, return any [i, j] with i + 1 < j, such that:

arr[0], arr[1], ..., arr[i] is the first part,
arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
All three parts have equal binary values.
If it is not possible, return [-1, -1].

Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.



Example 1:

Input: arr = [1,0,1,0,1]
Output: [0,3]
Example 2:

Input: arr = [1,1,0,1,1]
Output: [-1,-1]
Example 3:

Input: arr = [1,1,0,0,1]
Output: [0,2]


Constraints:

3 <= arr.length <= 3 * 104
arr[i] is 0 or 1
 */
public class ThreeEqualParts {

    public static void main(String[] args) {

        ThreeEqualParts obj = new ThreeEqualParts();
        int[] ints = {1, 1, 0, 0, 1};
        int[] result = obj.threeEqualParts(ints);
        ArrayUtils.printArray(result);

    }

    public int[] threeEqualParts(int[] arr) {

        int n = arr.length;
        int numOfOnes = 0;
        for (int i = 0; i < n; i++) {
            numOfOnes += arr[i];
        }

        if (numOfOnes == 0) return new int[]{0, n - 1};

        if (numOfOnes % 3 != 0) return new int[]{-1, -1};

        numOfOnes /= 3;

        int currCount = 0;
        int start = 0;
        int mid = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) continue;

            if (currCount == 0) start = i;

            if (arr[i] == 1) currCount++;

            if (currCount == numOfOnes + 1) mid = i;

            if (currCount == 2 * numOfOnes + 1) end = i;
        }

        while (end < n && arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start++;
            mid++;
            end++;
        }

        if (end == n) return new int[]{start - 1, mid};
        return new int[]{-1, -1};
    }
}

/*
    This is such an Amazing Question.
    There are two things in the binary representation
    that you can trust.
    The first one is the number of one's in the representation
    You can't trust the number of zero's in the representation
    So if you count the number of one's in the given array and it's
    not divisible by 3 you can say that the solution is
    not possible.

    The Second thing you can trust is Representation itself after
    the first 1 in the number.

    i.e
            1 1 1 0 0
            0 0 0 1 1 1 0 0
            0 1 1 1 0 0

            This 3 representation are same.
            If you look carefully, all of them has 3 number of 1's and
            the representation after the number is after first 1 is
               1 1 1 0 0 .


           So you problem boils down to finding the first position of the three sub array.
           If you are able to do this.
           You can solve the problem. Else you can't.


           Use Math's to find the first position of the first 1.
           Look the Code.
 */