package com.interviewbit.graph;

import java.util.*;

public class CycleInDirectedGraph {

    public static void main(String[] args) {
        CycleInUndirectedGraph obj = new CycleInUndirectedGraph();
        int A = 5;
        int[][] B = {{1, 4}, {2, 1}, {4, 3}, {4, 5}, {2, 3}, {2, 4}, {1, 5}, {5, 3}, {2, 5}, {5, 1}, {4, 2}, {3, 1}, {5, 4}, {3, 4}, {1, 3}, {4, 1}, {3, 5}, {3, 2}, {5, 2}};
        int result = obj.solve(A, B);
        System.out.println(result);
    }

    public int solve(int A, int[][] B) {

        boolean[] visited = new boolean[A + 1];
        boolean[] recursive = new boolean[A + 1];

        LinkedList<Integer>[] adj = new LinkedList[A + 1];
        for (int i = 0; i <= A; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            adj[start].add(end);
        }

        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                if (isCyclic(i, visited, recursive, adj)) return 1;
            }
        }
        return 0;
    }

    public boolean isCyclic(int node, boolean[] visited, boolean[] recursive, LinkedList<Integer>[] adj) {

        if (recursive[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recursive[node] = true;

        LinkedList<Integer> neighbours = adj[node];

        for (int neighbour : neighbours) {
            boolean result = isCyclic(neighbour, visited, recursive, adj);
            if (result) return true;
        }

        recursive[node] = false;

        String a = "XOXXXXOOXX XOOOOXOOXX OXXOOXXXOO OXOXOOOXXO OXOOXXOOXX OXXXXXXOXO OOXXXXOXOO ";
        String b = "XOXXXXOOXX XOOOOXOOXX OXXOOXXXOO OXXXOOOXXO OXXXXXOOXX OXXXXXXOXO OOXXXXOXOO";
        return false;
    }
}
