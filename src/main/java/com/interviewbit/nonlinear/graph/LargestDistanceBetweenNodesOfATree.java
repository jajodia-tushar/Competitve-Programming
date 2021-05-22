package com.interviewbit.nonlinear.graph;

import java.util.*;

public class LargestDistanceBetweenNodesOfATree {

    int deepestNode;
    int maxDistance = Integer.MIN_VALUE;

    public static void main(String[] args) {

        LargestDistanceBetweenNodesOfATree obj = new LargestDistanceBetweenNodesOfATree();
        int[] ints = {-1, 0, 0, 0, 3};
        int result = obj.solve(ints);
        System.out.println(result);
    }

    public int solve(int[] A) {
        int n = A.length;
        LinkedList<Integer>[] adj = new LinkedList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new LinkedList<>();
        }

        for(int i = 0; i < n; i++){
            if( A[i] == -1) continue;
            adj[i].add(A[i]);
            adj[A[i]].add(i);
        }

        boolean[] visited = new boolean[n];

        bfs(0,visited,adj);
        visited = new boolean[n];
        bfs(deepestNode,visited,adj);

        return maxDistance;

    }


    public void bfs(int index, boolean[] visited, LinkedList<Integer>[] adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentNode = -1;
            for (int k = 0; k < size; k++) {
                currentNode = queue.poll();
                visited[currentNode] = true;
                LinkedList<Integer> neighbours = adj[currentNode];

                for(int neighbour : neighbours){
                    if( !visited[neighbour]){
                        queue.add(neighbour);
                    }
                }
            }
            level++;
            if (level > maxDistance) {
                maxDistance = level;
                deepestNode = currentNode;
            }
        }
    }


}
