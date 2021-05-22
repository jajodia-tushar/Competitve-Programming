package com.interviewbit.graph;

import java.util.LinkedList;

public class CycleInUndirectedGraph {

    public static void main(String[] args) {

        CycleInUndirectedGraph obj = new CycleInUndirectedGraph();
        int A = 2;
        int[][] B = {{1, 2}};
        int result = obj.solve(A, B);
        System.out.println(result);

    }

    public int solve(int A, int[][] B) {

        boolean[] visited = new boolean[A + 1];
        LinkedList<Integer>[] adj = new LinkedList[A + 1];

        for (int i = 0; i <= A; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];
            adj[start].add(end);
            adj[end].add(start);
        }

        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                boolean result = isCyclic(i, visited, -1, adj);
                if (result) return 1;
            }
        }
        return 0;
    }

    public boolean isCyclic(int nodeToVisit, boolean[] visited, int parent, LinkedList<Integer> adj[]) {

        visited[nodeToVisit] = true;
        LinkedList<Integer> neighbour = adj[nodeToVisit];

        for (int nextNeighbour : neighbour) {
            if (!visited[nextNeighbour]) {
                boolean result = isCyclic(nextNeighbour, visited, nodeToVisit, adj);
                if (result) {
                    return true;
                }
            } else if(nextNeighbour != parent){
                return true;
            }
        }
        return false;
    }
}
