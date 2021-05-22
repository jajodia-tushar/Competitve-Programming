package com.interviewbit.nonlinear.graph;

import java.util.*;

public class SnackAndLadder {

    public static void main(String[] args) {

        SnackAndLadder obj = new SnackAndLadder();

        int[][] A = {{5, 66}, {9, 88}};
        int[][] B = {{67, 8}};

        int result = obj.snakeLadder(A, B);
        System.out.println(result);

    }

    public int snakeLadder(int[][] A, int[][] B) {

        boolean[] visited = new boolean[101];
        int minCount = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        int steps = 0;
        while (!queue.isEmpty()) {
            int sizeOfBranch = queue.size();
            for (int i = 0; i < sizeOfBranch; i++) {
                int currPosition = queue.poll();
                if (currPosition == 100) {
                    minCount = Math.min(minCount, steps);
                }
                if (!visited[currPosition]) {
                    visited[currPosition] = true;
                    for (int j = 1; j < 7; j++) {
                        int nextPossibleLocation = currPosition + j;
                        if ((nextPossibleLocation) <= 100) {
                            boolean shouldBeProcess = true;
                            for (int k = 0; k < B.length; k++) {
                                if (B[k][0] == nextPossibleLocation) {
                                    shouldBeProcess = false;
                                    break;
                                }
                            }

                            for (int k = 0; k < A.length; k++) {
                                if (A[k][0] == nextPossibleLocation) {
                                    nextPossibleLocation = A[k][1];
                                }
                            }

                            if (shouldBeProcess) {
                                queue.add(nextPossibleLocation);
                            }
                        }
                    }
                }
            }
            steps++;
        }

        if (minCount == Integer.MAX_VALUE) minCount = -1;
        return minCount;
    }
}
