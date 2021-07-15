package com.interviewbit.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    In this article, the BFS based solution is discussed.
    We do a BFS traversal of the given graph. For every visited vertex ‘v’,
    if there is an adjacent ‘u’ such that u is already visited and u is not
    a parent of v, then there is a cycle in the graph.
    If we don’t find such an adjacent for any vertex, we say that there is no cycle.
    We use a parent array to keep track of the parent vertex for a vertex
    so that we do not consider the visited parent as a cycle.
 */
public class DetectCycleInUndirectedGraphUsingBFS {

    public static void main(String[] args) {
        DetectCycleInDAGUsingBFS obj = new DetectCycleInDAGUsingBFS();

        int n = 6;
        int[][] adj = new int[][]{{5, 6}, {4, 6}, {5, 2}, {4, 1}, {2, 3}, {3, 1}};
        boolean result = obj.isCyclic(n, adj);
        System.out.println(result);
    }

    public boolean isCyclic(int n, int[][] edges) {

        LinkedList<Integer>[] adj = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adj[start].add(end);
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            LinkedList<Integer> neighbours = adj[currNode];
            for (int neighbour : neighbours) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    parent[neighbour] = currNode;
                } else if (parent[neighbour] != currNode) return true;
            }
        }
        return false;
    }
}

/*
    This one is similar to the one using DFS as well.
    Since this one is Undirected Graph so it is easy.
    We are taking a parent array and for every node
    we are trying to see all it's neighbours if
    it is not visited, visit it and then add parent of
    the neighbour as curr node.
    If it is already visited make sure that
    current node is the parent of the neighbour.
    If the parent of already visited node is different
    than there must have cycle so we have
    already visited that node from other node and
    so the parent is also different.

 */