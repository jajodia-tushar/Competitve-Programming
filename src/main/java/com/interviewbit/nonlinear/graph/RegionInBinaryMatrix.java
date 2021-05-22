package com.interviewbit.nonlinear.graph;

import java.util.Stack;

public class RegionInBinaryMatrix {

    public static void main(String[] args) {

        RegionInBinaryMatrix obj = new RegionInBinaryMatrix();
        int[][] ints = {{0, 0, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int result = obj.solve(ints);
        System.out.println(result);

    }

    public int count = 0;

    public int solve(int[][] A) {

        int row = A.length;
        int col = A[0].length;
        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1 && !visited[i][j]) {
                    // System.out.println(" Calling DFS ");
                    count = 0;
                    DFS(A, i, j, visited);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    void DFS(int[][] M, int row, int col, boolean[][] visited) {
        int[] rowNbr = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] colNbr = {1, -1, 0, 1, -1, 0, 1, -1};

        Stack<Point> stack = new Stack<>();
        Point first = new Point(row, col);
        stack.push(first);

        while (!stack.isEmpty()) {
            Point current = stack.pop();
            // System.out.println("In Stack for "+current.x+" -- "+current.y + " -- "+count);

            if(visited[current.x][current.y]) continue;
            visited[current.x][current.y] = true;
            for (int k = 0; k < 8; k++) {
                if (isSafe(M, current.x + rowNbr[k], current.y + colNbr[k], visited)) {
                    Point newPoint = new Point(current.x + rowNbr[k], current.y + colNbr[k]);
                    stack.push(newPoint);
                }
            }
            count++;
        }
    }

    boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        return ((row >= 0) && (row < M.length) && (col >= 0)
                && (col < M[0].length)
                && (M[row][col] == 1 && !visited[row][col]));
    }
}


