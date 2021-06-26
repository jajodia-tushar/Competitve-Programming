package com.interviewbit.graph;

import java.util.ArrayList;

public class UnionFindAlgorithm {

    public static void main(String[] args) {
        UnionFindAlgorithm obj = new UnionFindAlgorithm();
        int[][] adj = {{0, 1}, {0, 2}, {1, 2}};
        boolean result = obj.detectCycle(adj, 3);
        System.out.println(result);
    }

    public boolean detectCycle(int[][] adj, int nodes) {

        int[] parent = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            parent[i] = -1;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int[] edge : adj) {
            int start = edge[0];
            int end = edge[1];
            Edge currEdge = new Edge(start, end);
            edges.add(currEdge);
        }

        for (Edge edge : edges) {

            int x = find(parent, edge.start);
            int y = find(parent, edge.end);

            if (x == y)
                return true;
            union(parent, x, y);
        }

        return false;
    }

    public int find(int parent[], int node) {
        if (parent[node] == -1)
            return node;
        return find(parent, parent[node]);
    }

    public void union(int parent[], int x, int y) {
        parent[x] = y;
    }
}

class Edge {
    public int start;
    public int end;

    public Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}