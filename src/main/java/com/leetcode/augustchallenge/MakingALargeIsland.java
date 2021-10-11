package com.leetcode.augustchallenge;

/*
    You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
    Return the size of the largest island in grid after applying this operation.
    An island is a 4-directionally connected group of 1s.

    Example 1:

    Input: grid = [[1,0],[0,1]]
    Output: 3
    Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

    Example 2:
    Input: grid = [[1,1],[1,0]]
    Output: 4
    Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.

    Example 3:
    Input: grid = [[1,1],[1,1]]
    Output: 4
    Explanation: Can't change any 0 to 1, only one island with area = 4.


    Constraints:
    n == grid.length
    n == grid[i].length
    1 <= n <= 500
    grid[i][j] is either 0 or 1.

 */


import com.interviewbit.utils.ArrayUtils;

public class MakingALargeIsland {

    public static void main(String[] args) {
        MakingALargeIsland obj = new MakingALargeIsland();
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 1, 1, 1, 0, 0}};
        ArrayUtils.printArray(grid);
        int result = obj.largestIsland(grid);
        System.out.println(result);
    }

    public int largestIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        boolean[][] visited;
        boolean isZeroPresent = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    visited = new boolean[row][col];
                    grid[i][j] = 1;
                    isZeroPresent = true;
                    max = Math.max(max, dfs(i, j, grid, visited));
                    grid[i][j] = 0;
                }
            }
        }

        if (!isZeroPresent) return row * col;
        return max;
    }

    public int dfs(int x, int y, int[][] grid, boolean[][] visited) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y])
            return 0;
        if (grid[x][y] == 0) return 0;

        visited[x][y] = true;
        int count = 1;
        count += dfs(x + 1, y, grid, visited);
        count += dfs(x, y + 1, grid, visited);
        count += dfs(x - 1, y, grid, visited);
        count += dfs(x, y - 1, grid, visited);

        // System.out.println("Returning Count of " + count + " From (" + x + "," + y + ")");
        return count;
    }
}
