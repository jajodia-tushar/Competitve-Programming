package com.interviewbit.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDGUsingBFS {

    public static void main(String[] args) {
        DetectCycleInDGUsingBFS obj = new DetectCycleInDGUsingBFS();

        int n = 6;
        int[][] adj = new int[][]{{5, 6}, {4, 6}, {5, 2}, {4, 1}, {2, 3}, {3, 1}, {1, 2}};
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

        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> neighbours = adj[i];
            for (int neighbour : neighbours) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {

            int currNode = queue.poll();
            LinkedList<Integer> neighbours = adj[currNode];
            for (int neighbour : neighbours) {
                if (--inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
            count++;
        }

        return count != n;
    }
}

/*
    See the Overall Idea of the this technique is easy.
    The Main Idea is see in DAG there must at least One Node
    with in degree as 0 and one Node with out degree as 0;

    So if we calculate the in degree for all the vertexes
    and we push in the queue the the vertexes having in degree
    as 0, What we are trying to do here, actually trying to add
    in the queue that have no place to visit now.

    while visiting We also decrease the in degree of it's neighbours
    now here interesting thing.
    See if there is a Cycle that means we are able to reach at least one
    vertex from one more location right ?
    So the in degree of that vertex would me 1 more.

    Now which traversing in BFS way we are only decreasing the in degree of
    vertex that are neighbour to current Node.
    Idea is A node will be visited only if all it's parent are visited.
    In Given Example Node 6 will be visited only after all it's parent
    are visited.

    So Consider the case where there is no cycle and all the vertex are connected .
    In that case we visit a vertex if all it's parent are visited so it is possible.
    But in cycle, in this case 2 1 3.
    Here to visit vertex 2 we will first need to visit vertex 5 and 1,
    And to visit vertex 1 we will need to visit vertex 3 and 4.
    And to visit vertex 3 we will need to visit the vertex 2.
    So there is a cycle.


 */
