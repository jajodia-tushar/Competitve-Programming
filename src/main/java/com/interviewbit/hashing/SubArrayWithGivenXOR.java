package com.interviewbit.hashing;

import java.util.HashMap;

/*
Problem Description

Given an array of integers A and an integer B.

Find the total number of subarrays having bitwise XOR of all elements equals to B.



Problem Constraints
1 <= length of the array <= 105

1 <= A[i], B <= 109



Input Format
The first argument given is the integer array A.
The second argument given is integer B.



Output Format
Return the total number of subarrays having bitwise XOR equals to B.



Example Input
Input 1:

 A = [4, 2, 2, 6, 4]
 B = 6
Input 2:

 A = [5, 6, 7, 8, 9]
 B = 5


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
Explanation 2:

 The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]
 */
public class SubArrayWithGivenXOR {

    public static void main(String[] args) {

    }

    public int solve(int[] A, int B) {

        HashMap<Integer, Integer> maps = new HashMap<>();
        int n = A.length;
        maps.put(0, 1);
        int xor = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            xor ^= A[i];
            int required = xor ^ B;
            if (maps.containsKey(required)) {
                count += maps.get(required);
            }
            maps.put(xor, maps.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}

/*
    Look at Largest Continuous Sequence Zero Sum.

    Idea is same. You have to store current xor value in the hashmap.
    and if you find the same sum array with same xor value you increase the count.

    So Our hashmap will actually store the number of sub array with given xor values.

    Now when you are iterating your current xor value is x and you need y to make it
    required xor so you see in the map if y is there meaning that
    there was already some sub array with xor value equal to y
    now if you remove that sub array or only consider the sub array after that sub array
    you will get required xor values.
    So you store the number of such sub array and you can quickly add then up.

    You will understand.
 */