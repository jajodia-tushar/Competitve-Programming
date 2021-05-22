package com.interviewbit.nonlinear.graph;

public class BlackShapes {

    public static void main(String[] args) {

        BlackShapes obj = new BlackShapes();
        String[] A = {"OOOXOOO", "OOXXOXO", "OXOOOXO"};

        int result = obj.black(A);
        System.out.println(result);
    }

    public int black(String[] A) {

        int n = A.length;
        int m = A[0].length();

        boolean[][] visited = new boolean[n + 1][m + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1].charAt(j - 1) == 'X' && !visited[i][j]) {
                    // System.out.println(" I am here "+ i + " -- "+ j);
                    dfs(i, j, visited, A);
                    count++;
                } else {
                    // System.out.println(" Sorry "+ i + " -- "+ j);
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, boolean[][] visited, String[] A) {
        visited[row][col] = true;

        if (isSafe(row + 1, col, visited, A)) dfs(row + 1, col, visited, A);
        if (isSafe(row, col + 1, visited, A)) dfs(row, col + 1, visited, A);
        if (isSafe(row - 1, col, visited, A)) dfs(row - 1, col, visited, A);
        if (isSafe(row, col - 1, visited, A)) dfs(row, col - 1, visited, A);

    }

    public boolean isSafe(int row, int col, boolean[][] visited, String[] A) {
        return (row >= 1 && row <= A.length && col >= 1 && col <= A[0].length() &&
                A[row - 1].charAt(col - 1) == 'X' && !visited[row][col]);
    }
}
