package com.leetcode;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:


Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Example 2:

Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]


Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105
Accepted
137,654
Submissions
301,273
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {

        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        int[][] heights = {{8, 13, 11, 18, 14, 16, 16, 4, 4, 8, 10, 11, 1, 19, 7}, {2, 9, 15, 16, 14, 5, 8, 15, 9, 5, 14, 6, 10, 15, 5}, {15, 16, 17, 10, 3, 6, 3, 4, 2, 17, 0, 12, 4, 1, 3}, {13, 6, 13, 15, 15, 16, 4, 10, 7, 4, 19, 19, 4, 9, 13}, {7, 1, 9, 14, 9, 11, 5, 4, 15, 19, 6, 0, 0, 13, 5}, {9, 9, 15, 12, 15, 5, 1, 1, 18, 1, 2, 16, 15, 18, 9}, {13, 0, 4, 18, 12, 0, 11, 0, 1, 15, 1, 15, 4, 2, 0}, {11, 13, 12, 16, 9, 18, 6, 8, 18, 1, 5, 12, 17, 13, 5}, {7, 17, 2, 5, 0, 17, 9, 18, 4, 13, 6, 13, 7, 2, 1}, {2, 3, 9, 0, 19, 6, 6, 15, 14, 4, 8, 1, 19, 5, 9}, {3, 10, 5, 11, 7, 14, 1, 5, 3, 19, 12, 5, 2, 13, 16}, {0, 8, 10, 18, 17, 5, 5, 8, 2, 11, 5, 16, 4, 9, 14}, {15, 9, 16, 18, 9, 5, 2, 5, 13, 3, 10, 19, 9, 14, 3}, {12, 11, 16, 1, 10, 12, 6, 18, 6, 6, 18, 10, 9, 5, 2}, {17, 9, 6, 6, 14, 9, 2, 2, 13, 13, 15, 17, 15, 3, 14}, {18, 14, 12, 6, 18, 16, 4, 10, 19, 5, 6, 8, 9, 1, 6}};

        System.out.println(obj.pacificAtlantic(heights));
        ArrayUtils.printArray(heights);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] A = new boolean[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 || j == m - 1) {
                    A[i][j] = true;
                } else {
                    if (A[i + 1][j] && heights[i + 1][j] <= heights[i][j])
                        A[i][j] = true;

                    if (A[i][j + 1] && heights[i][j + 1] <= heights[i][j])
                        A[i][j] = true;
                }
            }
        }

        boolean[][] P = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    P[i][j] = true;
                } else {
                    if (P[i - 1][j] && heights[i - 1][j] <= heights[i][j])
                        P[i][j] = true;

                    if (P[i][j - 1] && heights[i][j - 1] <= heights[i][j])
                        P[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {

                } else if (i == 0) {
                    if (A[i][j - 1] && heights[i][j - 1] <= heights[i][j])
                        A[i][j] = true;
                } else if (j == 0) {
                    if (A[i - 1][j] && heights[i - 1][j] <= heights[i][j])
                        A[i][j] = true;
                } else {
                    if (A[i - 1][j] && heights[i - 1][j] <= heights[i][j])
                        A[i][j] = true;

                    if (A[i][j - 1] && heights[i][j - 1] <= heights[i][j])
                        A[i][j] = true;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                } else if (i == n - 1) {
                    if (P[i][j + 1] && heights[i][j + 1] <= heights[i][j])
                        P[i][j] = true;
                } else if (j == m - 1) {
                    if (P[i + 1][j] && heights[i + 1][j] <= heights[i][j])
                        P[i][j] = true;
                } else {
                    if (P[i + 1][j] && heights[i + 1][j] <= heights[i][j])
                        P[i][j] = true;

                    if (P[i][j + 1] && heights[i][j + 1] <= heights[i][j])
                        P[i][j] = true;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (A[i][j] && P[i][j]) {
                    List<Integer> innerResult = new ArrayList<>();
                    innerResult.add(i);
                    innerResult.add(j);
                    result.add(innerResult);
                }
            }
        }
        ArrayUtils.printArray(A);
        System.out.println("--------------------------------------");
        ArrayUtils.printArray(P);
        System.out.println("--------------------------------------");
        return result;
    }
}

