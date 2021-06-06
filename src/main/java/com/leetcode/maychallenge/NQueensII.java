package com.leetcode.maychallenge;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1


Constraints:
1 <= n <= 9
 */

import java.util.*;

public class NQueensII {


    public static void main(String[] args) {
        NQueensII obj = new NQueensII();
        int result = obj.totalNQueens(10);
        System.out.println(result);
    }

    int count = 0;

    public int totalNQueens(int n) {

        HashSet<Integer> diagonal1 = new HashSet<>();
        HashSet<Integer> diagonal2 = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        solve(0, diagonal1, diagonal2, columns, n);
        return count;
    }


    public void solve(int row, HashSet<Integer> d1, HashSet<Integer> d2, HashSet<Integer> columns,
                      int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!columns.contains(c) && !d1.contains(c + row) && !d2.contains(c - row)) {
                HashSet<Integer> newD1 = new HashSet<>(d1);
                HashSet<Integer> newD2 = new HashSet<>(d2);
                HashSet<Integer> newColumns = new HashSet<>(columns);
                newD1.add(c + row);
                newD2.add(c - row);
                newColumns.add(c);
                solve(row + 1, newD1, newD2, newColumns, n);
            }
        }

    }

}
