package com.interviewbit.graph;

public class WordSearchBoard {

    public static void main(String[] args) {
        WordSearchBoard obj = new WordSearchBoard();
        String[] A = {"ABCE", "SFCS", "ADEE"};
        String B = "CABBFFEAC";
        System.out.println(obj.exist(A, B));
    }

    public int exist(String[] A, String B) {

//        int row = A.length;
//        int col = A[0].length();
//        char ch = B.charAt(0);
//        boolean[][] visited;
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (A[i].charAt(j) == ch) {
//                    visited = new boolean[row][col];
//                    boolean result = solve(i, j, A, B, 1, visited);
//                    if (result) return 1;
//                }
//            }
//        }
//        return 0;

        int b = B.length();
        if (b == 0) return 1;

        int n = A.length;
        if (n == 0) return 0;

        int m = A[0].length();
        if (m == 0) return 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == B.charAt(0)) {
                    boolean temp = isExist(i, j, 0, A, B);
                    if (temp)
                        return 1;
                }
            }
        }

        return 0;
    }

//    public boolean solve(int row, int col, String[] A, String B, int bIndex, boolean[][] visited) {
//
//        visited[row][col] = true;
//        if (bIndex >= B.length()) return true;
//        char toMatch = B.charAt(bIndex);
//        boolean result = false;
//
//        if (isSafe(row, col - 1, A, toMatch) && !visited[row][col - 1]) {
//            result = solve(row, col - 1, A, B, bIndex + 1, visited);
//        }
//
//        if (isSafe(row, col + 1, A, toMatch) && !visited[row][col + 1]) {
//            result |= solve(row, col + 1, A, B, bIndex + 1, visited);
//        }
//
//        if (isSafe(row - 1, col, A, toMatch) && !visited[row - 1][col]) {
//            result |= solve(row - 1, col, A, B, bIndex + 1, visited);
//        }
//
//        if (isSafe(row + 1, col, A, toMatch) && !visited[row + 1][col]) {
//            result |= solve(row + 1, col, A, B, bIndex + 1, visited);
//        }
//
//        if (isSafe(row, col, A, toMatch)) {
//            result |= solve(row, col, A, B, bIndex + 1, visited);
//        }
//
//        return result;
//    }


//    public boolean isSafe(int row, int col, String[] A, char ch) {
//        if (row >= 0 && row < A.length && col >= 0 && col < A[0].length()) {
//            char charInArray = A[row].charAt(col);
//            return charInArray == ch;
//        }
//        return false;
//    }

    boolean isExist(int i, int j, int index, String[] A, String B) {
        if (index == B.length())
            return true;

        int n = A.length;
        int m = A[0].length();

        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;

        if (A[i].charAt(j) != B.charAt(index))
            return false;

        return isExist(i, j + 1, index + 1, A, B) ||
                isExist(i, j - 1, index + 1, A, B) ||
                isExist(i + 1, j, index + 1, A, B) ||
                isExist(i - 1, j, index + 1, A, B);
    }
}
