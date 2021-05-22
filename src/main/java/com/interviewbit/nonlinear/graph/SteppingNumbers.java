package com.interviewbit.nonlinear.graph;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;

public class SteppingNumbers {

    ArrayList<Integer> result;

    public static void main(String[] args) {

        SteppingNumbers obj = new SteppingNumbers();
        int[] result = obj.stepnum(10, 100);
        ArrayUtils.printArray(result);

    }

    public int[] stepnum(int A, int B) {

        int[][] adj = {{1}, {0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 7}, {6, 8}, {7, 9}, {8}};
        result = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            dfs(i, A, B, adj, i);
        }

        return result.stream().sorted().distinct().mapToInt(x -> x).toArray();
    }

    public void dfs(int node, int min, int max, int[][] adj, int currentNumber) {

        if (currentNumber >= min && currentNumber <= max) {
            result.add(currentNumber);
        }

        if (currentNumber < max) {
            int[] neighbours = adj[node];
            for (int i = 0; i < neighbours.length; i++) {
                int nextNumber = currentNumber * 10 + neighbours[i];
                dfs(neighbours[i], min, max, adj, nextNumber);
            }
        }
    }
}
