package com.interviewbit.heapsandmaps;

import java.util.PriorityQueue;

/*
Problem Description

Given an array A , representing seats in each row of a stadium. You need to sell tickets to B people.

Each seat costs equal to the number of vacant seats in the row it belongs to. The task is to maximize the profit by selling the tickets to B people.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= 1000000



Input Format
First argument is the array A.

Second argument is integer B.



Output Format
Return one integer, the answer to the problem.



Example Input
Input 1:

A = [2, 3]
B = 3
Input 2:

A = [1, 4]
B = 2


Example Output
Output 1:

7
Output 2:

7


Example Explanation
Explanation 1:

 First you serve the seat with number = 3. Then with 2 and then with 2. hence answer = 3 + 2 + 2 = 7.
Explanation 2:

 You give both tickets from the row with 4 seats. 4 + 3 = 7.
 */
public class ProfitMaximisation {

    public static void main(String[] args) {
        ProfitMaximisation obj = new ProfitMaximisation();
        int[] ints = {2, 3, 5, 6, 88};
        int B = 4;
        int result = obj.solve(ints, B);
        System.out.println(result);
    }

    public int solve(int[] A, int B) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int n = A.length;

        for (int i = 0; i < n; i++) {
            queue.add(A[i]);
        }

        int profit = 0;
        while (B-- > 0) {
            int value = queue.poll();
            profit += value;
            if (value >= 1) {
                queue.add(value - 1);
            }
        }

        return profit;
    }
}
/*
    There is nothing in there,
    You always have sell the ticket to the maximum vacant Row.
    This is the best part to use PriorityQueue or Heaps.

 */