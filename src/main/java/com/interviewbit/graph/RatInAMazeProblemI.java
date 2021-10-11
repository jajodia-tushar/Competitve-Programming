package com.interviewbit.graph;

import java.util.ArrayList;

/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Example 1:

    Input:
    N = 4
    m[][] = {{1, 0, 0, 0},
             {1, 1, 0, 1},
             {1, 1, 0, 0},
             {0, 1, 1, 1}}
    Output:
    DDRDRR DRDDRR
    Explanation:
    The rat can reach the destination at
    (3, 3) from (0, 0) by two paths - DRDDRR
    and DDRDRR, when printed in sorted order
    we get DDRDRR DRDDRR.
    Example 2:
    Input:
    N = 2
    m[][] = {{1, 0},
             {1, 0}}
    Output:
    -1
    Explanation:
    No path exists and destination cell is
    blocked.
    Your Task:
    You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order.
    Note: In case of no path, return an empty list. The driver will output "-1" automatically.

    Expected Time Complexity: O((N2)4).
    Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

    Constraints:
    2 ≤ N ≤ 5
    0 ≤ m[i][j] ≤ 1
 */
public class RatInAMazeProblemI {

    public static void main(String[] args) {
        int N = 4;
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        ArrayList<String> result = findPath(m, N);
        System.out.println(result);

    }

    static int count = 0;
    static ArrayList<String> result;

    public static ArrayList<String> findPath(int[][] m, int n) {

        boolean[][] visited = new boolean[n][n];
        result = new ArrayList<>();
        dfs(m, visited, "", 0, 0, n);
        // System.out.println(count);
        // Collections.sort(result);
        return result;

    }

    public static void dfs(int[][] m, boolean[][] visited, String curr, int x, int y, int n) {

        visited[x][y] = true;

        if (x == n - 1 && y == n - 1 && m[x][y] == 1) {
            count++;
            result.add(curr);
            visited[x][y] = false;
            return;
        }

        if (m[x][y] == 0) return;

        if (isSafe(x + 1, y, visited, n)) {
            dfs(m, visited, curr + "D", x + 1, y, n);
        }

        if (isSafe(x, y - 1, visited, n)) {
            dfs(m, visited, curr + "L", x, y - 1, n);
        }

        if (isSafe(x, y + 1, visited, n)) {
            dfs(m, visited, curr + "R", x, y + 1, n);
        }

        if (isSafe(x - 1, y, visited, n)) {
            dfs(m, visited, curr + "U", x - 1, y, n);
        }


        visited[x][y] = false;
    }

    public static boolean isSafe(int x, int y, boolean[][] visited, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y];
    }
}

/*
    This is kind of a Backtracking problem with DFS idea from Graph.
    Since we need sorted array. So no need to sort at last. The way we are making the
    dfs recursive call will do the trick  R -> L -> R -> U.




 */