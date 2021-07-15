package com.interviewbit.graph;

/*

Return An Array with Topological Sorting of a Graph using BFS Technique

 */


import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {


    public static void main(String[] args) {
        TopologicalSortBFS obj = new TopologicalSortBFS();

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


        int[] inDegree = new int[n + 1];

        // Calculating InDegree for All Vertex
        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> neighbour = adj[i];
            for (int dest : neighbour) {
                inDegree[dest]++;
            }
        }

        //Initially Adding Only the 0 inDegree Vertex
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {

            int node = queue.poll();
            result.add(node);

            LinkedList<Integer> neighbours = adj[node];
            for (int neighbour : neighbours) {
                // Decrease and if the inDegree is 0 add to Queue
                if (--inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}

