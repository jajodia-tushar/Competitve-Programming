package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*
Problem Description

Given are Three arrays A, B and C.

Return the sorted list of numbers that are present in atleast 2 out of the 3 arrays.

Problem Constraints
1 <= |A|, |B|, |C| <= 100000

1 <= A[i], B[i], C[i] <= 100000

A, B, C may or may not have pairwise distinct elements.

Input Format
First argument is the array A.

First argument is the array B.

First argument is the array C.

Output Format
Return a sorted array of numbers.

Example Input
Input 1:

A = [1, 1, 2]
B = [2, 3]
C = [3]
Input 2:

A = [1, 2]
B = [1, 3]
C = [2, 3]

Example Output
Output 1:

[2, 3]
Output 2:

[1, 2, 3]

Example Explanation
Explanation 1:

1 is only present in A. 2 is present in A and B. 3 is present in B and C.
Explanation 2:

All numbers are present in at least 2 out of 3 lists.
 */
public class TwoOutOfThree {

    public static void main(String[] args) {
        int[][] tasks = {{1, 2, 3}, {3, 4, 5}, {2, 3, 4}};
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);
        ArrayUtils.printArray(tasks);
    }

    public int[] solve(int[] A, int[] B, int[] C) {

        Map<Integer, Set<Integer>> maps = new TreeMap<>();

        for (int num : A) {
            addToMap(maps, 1, num);
        }

        for (int num : B) {
            addToMap(maps, 2, num);
        }

        for (int num : C) {
            addToMap(maps, 3, num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : maps.entrySet()) {
            Set<Integer> set = entry.getValue();
            int value = entry.getKey();
            if (set.size() >= 2) list.add(value);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

    public void addToMap(Map<Integer, Set<Integer>> maps, int arrayNumber, int number) {
        Set<Integer> sets = maps.getOrDefault(number, new HashSet<>());
        sets.add(arrayNumber);
        maps.put(number, sets);
    }

    static int solve(int n, int t, int[][] task){
        // Write your code here

        int currentPosition = 0;
        int timeLeft = t;
        int count = 0;
        Arrays.sort(task,Comparator.comparing(a -> a[0]));

        for(int i = 0; i < n; i++){
            int position = task[i][0];
            int timeReq  = task[i][1];
            if(isPossible(currentPosition,timeLeft,position,timeReq)){
                count++;
            }
        }
        return count;
    }

    static boolean isPossible(int currentPosition, int timeLeft, int position, int timeReq) {

        int timeToReach = position - currentPosition;
        int timeToReturn = position;
        int totalTime = timeToReach + timeToReturn + timeReq;

        return totalTime < timeLeft;
    }
}

/*
    Think in terms of tracking the number.
    If you are able to track in a number is repeated in which Array.
    Then The problem will be solved.

    Make Number as Key and Set as value (don't make arraylist as we don't want repeated numbers)


 */