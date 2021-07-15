package com.interviewbit.graph;


import com.interviewbit.utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Stack;

/*
    Topological Sort of a Directed Acyclic Graph is linear ordering of vertices such
    that for every directed edge u, v
    Vertex U comes before Vertex V
    There can be more than one topological sorting for a graph.

    PostOrder Traversal of DFS.
    i.e Add to stack while returning from DFS or at the end of DFS.
 */
public class TopologicalSorting {

    public static void main(String[] args) {

        TopologicalSorting obj = new TopologicalSorting();

        int n = 6;
        int[][] adj = new int[][]{{5, 6}, {4, 6}, {5, 2}, {4, 1}, {2, 3}, {3, 1}};
        int[] result = obj.getTopologicalSortingOfGraph(n, adj);
        ArrayUtils.printArray(result);
    }

    public int[] getTopologicalSortingOfGraph(int n, int[][] edges) {

        LinkedList<Integer>[] adj = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adj[start].add(end);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(visited, stack, i, adj);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private void dfs(boolean[] visited, Stack<Integer> stack, int currNode, LinkedList<Integer>[] adj) {

        visited[currNode] = true;
        LinkedList<Integer> neighbours = adj[currNode];

        for (int n : neighbours) {
            if (!visited[n]) {
                dfs(visited, stack, n, adj);
            }
        }
        stack.push(currNode);
    }


}
