package com.interviewbit.graph;


/*
The above operations can be optimized to O(Log n) in worst case.
The idea is to always attach smaller depth tree under the root of the deeper tree.
This technique is called union by rank.
The term rank is preferred instead of height because if path
compression technique (we have discussed it below) is used,
then rank is not always equal to height.
Also, size (in place of height) of trees can also be used as rank.
Using size as rank also yields worst case time complexity as O(Logn)

 */

import java.util.ArrayList;

public class UnionFindAlgorithmRankMethod {

    public static void main(String[] args) {
        UnionFindAlgorithm obj = new UnionFindAlgorithm();
        int[][] adj = {{0, 1}, {0, 2}, {1, 2}};
        boolean result = obj.detectCycle(adj, 3);
        System.out.println(result);
    }

    public boolean detectCycle(int[][] adj, int nodes) {

        SubSet[] subSets = new SubSet[nodes];
        for (int i = 0; i < nodes; i++) {
            subSets[i] = new SubSet(i, 0);
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int[] edge : adj) {
            int start = edge[0];
            int end = edge[1];
            Edge currEdge = new Edge(start, end);
            edges.add(currEdge);
        }

        for (Edge edge : edges) {

            int x = find(subSets, edge.start);
            int y = find(subSets, edge.end);

            if (x == y)
                return true;
            else
                union(x, y, subSets);
        }

        return false;

    }

    public int find(SubSet[] subSets, int node) {
        if (subSets[node].parent == node) return node;
        subSets[node].parent = find(subSets, subSets[node].parent);  // This is Path Compression Part.
        return subSets[node].parent;
    }

    public void union(int x, int y, SubSet[] subSets) {

        // We will Come to why we are calling find again.
        int xParent = find(subSets, x);
        int yParent = find(subSets, y);

        if (subSets[xParent].rank < subSets[yParent].rank) {
            subSets[xParent].parent = yParent;
        } else if (subSets[xParent].rank > subSets[yParent].rank) {
            subSets[yParent].parent = xParent;
        } else {
            subSets[xParent].parent = yParent;
            subSets[yParent].rank++;                     // The Real Logic.
        }
    }

}

class SubSet {
    public int parent;
    public int rank;

    public SubSet(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}