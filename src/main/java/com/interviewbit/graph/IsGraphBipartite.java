package com.interviewbit.graph;


/*
    A Graph is Bipartite if all the nodes in the graph can be represented into
    two different sets A, B such that every edge on the graph connects node from
    Set A to Set B and no edge connects items in same set.

    If it is possible to divide the vertices of a Graph into two mutually exclusive
    and exhaustive subsets such that all the edges are across sets not within set.


    There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

    There are no self-edges (graph[u] does not contain u).
    There are no parallel edges (graph[u] does not contain duplicate values).
    If v is in graph[u], then u is in graph[v] (the graph is undirected).
    The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
    A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

    Return true if and only if it is bipartite.
 */

import java.util.*;

public class IsGraphBipartite {

    int[] colour;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {

        int vertices = graph.length;
        colour = new int[vertices];
        visited = new boolean[vertices];
        Arrays.fill(colour, -1);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                queue.add(i);
                colour[i] = 0;

                while (!queue.isEmpty()) {
                    int currentNode = queue.poll();
                    visited[currentNode] = true;
                    for (int neighbours : graph[currentNode]) {
                        if (colour[neighbours] == -1) {
                            colour[neighbours] = 1 - colour[currentNode];
                            queue.add(neighbours);
                        } else if (colour[neighbours] == colour[currentNode])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

/*
    Using the concept of Graph Colouring.
    A Property of a bipartite graph says that, it can be coloured using just two types of colour
    and no two adjacent vertices will have same colour.
    Doing BFS.
    You can do DFS as well.
 */