package com.interviewbit.graph;


import com.interviewbit.backtracking.Subset;

import java.util.Arrays;
import java.util.Comparator;

// Minimum Spanning Tree.
public class KruskalAlgorithm {

    public static void main(String[] args) {

        KruskalAlgorithm obj = new KruskalAlgorithm();
        int[][] connections = {{0, 1, 10}, {1, 3, 15}, {3, 2, 4}, {2, 0, 6}, {0, 3, 5}};
        int N = 4;

        int result = obj.mst(connections, N);
        System.out.println(result);
    }

    public int mst(int[][] connections, int n) {

        Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
        SubSet[] subSets = new SubSet[n];
        for (int i = 0; i < n; i++) {
            subSets[i] = new SubSet(i, 0);
        }

        int result = 0;
        int nEdges = 0;
        int index = 0;
        while (nEdges < n - 1) {

            int[] edge = connections[index];
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            int x = find(src, subSets);
            int y = find(dest, subSets);

            if (x != y) {
                union(x, y, subSets);
                nEdges++;
                result += cost;
            }
            index++;
        }
        return result;
    }

    public int find(int node, SubSet[] subsets) {
        if (subsets[node].parent == node) return node;
        subsets[node].parent = find(subsets[node].parent, subsets);
        return subsets[node].parent;
    }

    public void union(int x, int y, SubSet[] subsets) {

        int xParent = find(x, subsets);
        int yParent = find(y, subsets);

        if (subsets[xParent].rank > subsets[yParent].rank) {
            subsets[yParent].parent = xParent;
        } else if (subsets[xParent].rank < subsets[yParent].rank) {
            subsets[xParent].parent = yParent;
        } else {
            subsets[xParent].parent = yParent;
            subsets[yParent].rank++;
        }
    }

    static class SubSet {
        public int parent;
        public int rank;

        public SubSet(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
}
