package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BellManFordAlgorithm {

    public static void main(String[] args) {

        BellManFordAlgorithm obj = new BellManFordAlgorithm();
        int[][] edges = {
                {0, 1, -4}, {0, 7, 8}, {1, 2, -8},
                {1, 7, 11}, {2, 3, 7}, {2, 8, 2},
                {2, 5, 4}, {3, 4, -9}, {3, 5, 14},
                {4, 5, 10}, {5, 6, 2}, {6, 7, 1},
                {6, 8, 6}, {7, 8, 7}
        };

        int[] result = obj.shortestDistanceWithNegativeWeights(9, edges);
        ArrayUtils.printArray(result);
    }


    public int[] shortestDistanceWithNegativeWeights(int n, int[][] edges) {
        int[] w = new int[n];
        Arrays.fill(w, Integer.MAX_VALUE);
        w[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int cost = edge[2];

                if (w[start] != Integer.MAX_VALUE) {
                    if (w[start] + cost < w[end]) {
                        w[end] = w[start] + cost;
                    }
                }
            }
        }

        return w;

    }
}
