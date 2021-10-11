package com.interviewbit.graph;


import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/*
    Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it,
    find the longest distances from s to all other vertices in the given graph.
    The longest path problem for a general graph is not as easy as the shortest
    path problem because the longest path problem doesn’t have optimal substructure property.
    In fact, the Longest Path problem is NP-Hard for a general graph.
    However, the longest path problem has a linear time solution
    for directed acyclic graphs. The idea is similar to linear time solution for shortest path in a
    directed acyclic graph., we use Topological Sorting.
    We initialize distances to all vertices as minus infinite and distance to source as 0,
    then we find a topological sorting of the graph. Topological Sorting
    of a graph represents a linear ordering of the graph.
    Once we have topological order (or linear representation), we one by one process all
    vertices in topological order. For every vertex being processed, we update
    distances of its adjacent using distance of current vertex.
    Following figure shows step by step process of finding longest paths.
 */
public class LongestPathInADirectedAcyclicGraph {

    public static void main(String[] args) {

        LongestPathInADirectedAcyclicGraph obj = new LongestPathInADirectedAcyclicGraph();

        int[][] edges = {{0, 1, 5}, {0, 2, 3}, {1, 3, 6}, {1, 2, 2}, {2, 4, 4}, {2, 5, 2}, {2, 3, 7}, {3, 5, 1}, {3, 4, -1}, {4, 5, -2}};
        int nodes = 6;

        int[] result = obj.getMaximumDistance(nodes, edges, 1);
        ArrayUtils.printArray(result);
    }

    public int[] getMaximumDistance(int n, int[][] edges, int source) {

        LinkedList<Node>[] adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adj[start].add(new Node(end, weight));
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                DFS(0, visited, adj, stack);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MIN_VALUE);

        distance[source] = 0;

        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (distance[currNode] != Integer.MIN_VALUE) {
                LinkedList<Node> neighbour = adj[currNode];
                for (Node next : neighbour) {
                    if (distance[next.vertex] < distance[currNode] + next.weight) {
                        distance[next.vertex] = distance[currNode] + next.weight;
                    }
                }
            }
        }

        return distance;

    }

    public void DFS(int currNode, boolean[] visited, LinkedList<Node>[] adj, Stack<Integer> stack) {
        visited[currNode] = true;
        LinkedList<Node> neighbour = adj[currNode];
        for (Node next : neighbour) {
            if (!visited[next.vertex]) {
                DFS(next.vertex, visited, adj, stack);
            }
        }
        stack.push(currNode);
    }

    static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

/*
    Here Integer.MIN_VALUE will denote Infinity
 */
