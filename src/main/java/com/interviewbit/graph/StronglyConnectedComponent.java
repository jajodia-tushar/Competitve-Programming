package com.interviewbit.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

// SEE AGAIN
public class StronglyConnectedComponent {

    public static void main(String[] args) {

        StronglyConnectedComponent obj = new StronglyConnectedComponent();
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 5}, {4, 7}, {5, 6}, {6, 4}, {6, 7}};
        int nodes = 8;

        int result = obj.getStronglyConnectedComponents(nodes, edges);
        System.out.println(result);
    }

    public int getStronglyConnectedComponents(int n, int[][] edges) {

        LinkedList<Integer>[] adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adj[start].add(end);
        }

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        DFS(0, visited, adj, stack);
        adj = reverse(adj, n);

        int count = 0;
        visited = new boolean[n];
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (!visited[currNode]) {
                DFS2(currNode, visited, adj);
                count++;
            }
        }

        return count;
    }

    public LinkedList<Integer>[] reverse(LinkedList<Integer>[] adj, int nodes) {

        LinkedList<Integer>[] reverse = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            reverse[i] = new LinkedList<>();
        }

        for (int i = 0; i < nodes; i++) {
            LinkedList<Integer> neighbours = adj[i];
            for (int n : neighbours) {
                reverse[n].add(i);
            }
        }
        return reverse;
    }

    public void DFS(int currNode, boolean[] visited, LinkedList<Integer>[] adj, Stack<Integer> stack) {
        visited[currNode] = true;
        LinkedList<Integer> neighbour = adj[currNode];
        for (int next : neighbour) {
            if (!visited[next]) {
                DFS(next, visited, adj, stack);
            }
        }
        stack.push(currNode);
    }

    public void DFS2(int currNode, boolean[] visited, LinkedList<Integer>[] adj) {
        visited[currNode] = true;
        LinkedList<Integer> neighbour = adj[currNode];
        for (int next : neighbour) {
            if (!visited[next]) {
                DFS2(next, visited, adj);
            }
        }
    }
}

// Look Copy No 5. Page No 12-13 for Explanation
