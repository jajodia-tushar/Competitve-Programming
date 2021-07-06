package com.leetcode.julychallenge;

import java.util.*;

/*
An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.



Example 1:

Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 00 and 01 differ by one bit
- 01 and 11 differ by one bit
- 11 and 10 differ by one bit
- 10 and 00 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- 00 and 10 differ by one bit
- 10 and 11 differ by one bit
- 11 and 01 differ by one bit
- 01 and 00 differ by one bit
Example 2:

Input: n = 1
Output: [0,1]
 */
public class GrayCode {
    int num;

    public static void main(String[] args) {

        GrayCode obj = new GrayCode();
        List<Integer> result = obj.grayCode(4);
        System.out.println(result);
    }


    void grayCodeUtil(List<Integer> res, int n) {
        if (n == 0) {
            res.add(num);
            return;
        }
        grayCodeUtil(res, n - 1);
        num = num ^ (1 << (n - 1));
        grayCodeUtil(res, n - 1);
    }

    List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        num = 0;
        grayCodeUtil(res, n);

        return res;
    }

    public List<Integer> grayCodeOptimized(int n) {

        List<Integer> result = new ArrayList<>();
        int s = 1 << n;

        for (int i = 0; i < s; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }

    public List<Integer> grayCodeX(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        // Keeps track of the numbers present in the current sequence.
        Set<Integer> isPresent = new HashSet<>();
        // All Gray code sequence starts with 0
        isPresent.add(0);
        grayCodeHelper(result, n, isPresent);
        return result;
    }

    private boolean grayCodeHelper(List<Integer> result, int n, Set<Integer> isPresent) {
        if (result.size() == (1 << n)) return true;

        int current = result.get(result.size() - 1);
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (!isPresent.contains(next)) {
                isPresent.add(next);
                result.add(next);
                // If valid sequence found no need to search any further
                if (grayCodeHelper(result, n, isPresent)) return true;
                // If no valid sequence found delete the last added number and continue the search.
                isPresent.remove(next);
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}

/*
    The first Process
    grayCode(n - 1)
        invert Bit
    grayCode(n - 1)
    is still not understandable.

    I will explain to you,
    this one.
        let index be i and gray code for that index be g(i)
            now one interesting observation is
            i ^ g(i) = i / 2
            Try some values.
                0 ^ 0 --> 0
                1 ^ 1 --> 0
                2 ^ 3 --> 1
                3 ^ 2 --> 1
                4 ^ 6 --> 2
                5 ^ 7 --> 2
                6 ^ 5 --> 3
                7 ^ 4 --> 3
            So if we modify G(i) => i ^ (i / 2)

            We are done.
            So we are just doing this.
            In the Optimized Version of this Code.
 */
