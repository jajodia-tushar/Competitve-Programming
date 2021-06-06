package com.leetcode.junechallenge;


/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int result = obj.maxAreaOfIsland(grid);
        System.out.println(result);
    }

    int maxArea;
    int tempCount;

    public int maxAreaOfIsland(int[][] grid) {

        maxArea = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(i, j, visited, grid);
                    maxArea = Math.max(maxArea, tempCount);
                }
                tempCount = 0;
            }
        }

        return maxArea;
    }


    public void dfs(int row, int col, boolean[][] visited, int[][] grid) {

        if (row >= 0 && row < visited.length && col >= 0 && col < visited[0].length) {
            if (visited[row][col]) return;
            if (grid[row][col] != 1) return;
            tempCount++;
            visited[row][col] = true;
            dfs(row + 1, col, visited, grid);
            dfs(row, col + 1, visited, grid);
            dfs(row - 1, col, visited, grid);
            dfs(row, col - 1, visited, grid);
        }
    }
}

/*
Notes.
This is the classical Question of the Connected Components.
Just use DFS to traverse and 2 for loop to traverse not visited island even after previous dfs.
The max area can be tracked by the global area variable
 */