package com.interviewbit.graph;


import java.util.*;

/*
There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.

Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.



Example 1:



Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:



Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
Example 4:

Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
Output: 0


Constraints:

1 <= n <= 10^5
1 <= connections.length <= min(n*(n-1)/2, 10^5)
connections[i].length == 2
0 <= connections[i][0], connections[i][1] < n
connections[i][0] != connections[i][1]
There are no repeated connections.
No two computers are connected by more than one cable.
 */
public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {

        NumberOfOperationsToMakeNetworkConnected obj = new NumberOfOperationsToMakeNetworkConnected();
        int n = 11;
        int[][] connections = {
                {1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1},
                {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7}, {0, 7},
                {5, 7}
        };

        int result = obj.makeConnected(n, connections);
        System.out.println(result);
    }

    public int makeConnected(int n, int[][] connections) {

        int edges = connections.length;
        int required = n - 1;

        if (edges < required) return -1;
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : connections) {
            int start = edge[0];
            int end = edge[1];
            adj[start].add(end);
            adj[end].add(start);
        }

        boolean[] visited = new boolean[n];
        int count = -1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, LinkedList<Integer>[] adj, boolean[] visited) {
        LinkedList<Integer> neighbour = adj[node];
        for (int next : neighbour) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, adj, visited);
            }
        }
    }

    // Using Union Find Method

    public int makeConnectedX(int n, int[][] connections) {

        int edges = connections.length;
        if (edges < n - 1) return -1;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int count = 0;

        for (int[] edge : connections) {

            int start = edge[0];
            int end = edge[1];

            int x = getParent(start, parent);
            int y = getParent(end, parent);

            if (x == y) {
                count++;
            } else {
                union(x, y, parent);
            }
        }

        int nonRepeat = edges - count;
        int required = n - 1;

        return required - nonRepeat;
    }

    public int getParent(int node, int[] parent) {

        if (parent[node] == -1)
            return node;
        else return getParent(parent[node], parent);
    }

    public void union(int x, int y, int[] parent) {
        parent[x] = y;
    }

}
