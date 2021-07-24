package com.interviewbit.graph;


import java.util.*;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int nodes = 10;
        int[][] connections = {{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}};
        int source = 6;
        int destination = 0;
        int k = 7;
        int result = obj.findCheapestPriceUsingDP(nodes, connections, source, destination, k);
        System.out.println(result);

    }

    //=============================== Using DynamicProgramming ===============================================================


    public int findCheapestPriceUsingDP(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i <= k + 1; i++) {
            dp[i][src] = 0;
        }

        for (int i = 1; i <= k + 1; i++) {
            for (int[] f : flights) {
                if (dp[i - 1][f[0]] != Integer.MAX_VALUE) {
                    dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i - 1][f[0]] + f[2]);
                }
            }
        }
        return dp[k + 1][dst] == Integer.MAX_VALUE ? -1 : dp[k + 1][dst];
    }

    //=============================== Using DFS ===========================================================

    int minValue = Integer.MAX_VALUE;

    public int findCheapestPriceUsingDFS(int n, int[][] flights, int src, int dst, int k) {

        LinkedList<Node>[] adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : flights) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adj[start].add(new Node(end, weight));
        }


        boolean[] visited = new boolean[n];
        dfs(src, adj, dst, k, 0, 0, visited);

        return minValue == Integer.MAX_VALUE ? -1 : minValue;


    }

    public void dfs(int currNode, LinkedList<Node>[] adj, int dst, int k, int currK,
                    int currCost, boolean[] visited) {

        if (currK > k + 1) return;
        if (currCost >= minValue) return;

        if (currNode == dst) {
            minValue = Math.min(minValue, currCost);
            return;
        }

        visited[currNode] = true;
        LinkedList<Node> neighbour = adj[currNode];
        for (Node next : neighbour) {
            if (!visited[next.vertex]) {
                dfs(next.vertex, adj, dst, k, currK + 1, currCost + next.weight, visited);
            }
        }
        visited[currNode] = false;
    }

    static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    // Similarly We Can do the same using BFS as well.
    // Each level will represent a value of k.
    // Easy right ?
    //=========================================================================================================

}

// Look the Copy for Explanation
