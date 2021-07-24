package com.interviewbit.graph;

import java.util.*;

/*
    Given an undirected graph and an integer M.
    The task is to determine if the graph can be colored with at most M
    colors such that no two adjacent vertices of the graph are colored
    with the same color. Here coloring of a graph means the assignment
    of colors to all vertices. Print 1 if it is possible to colour
    vertices and 0 otherwise.

 */
public class MColouringProblem {

    public static void main(String[] args) {

        List<Integer>[] adj = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(4);
        adj[2].add(4);
        adj[3].add(4);
        adj[4].add(0);
        adj[4].add(2);
        adj[4].add(3);

        int[] color = new int[5];

        boolean result = graphColoring(adj, color, 5, 3);
        System.out.println(result);

    }

    public static boolean graphColoring(List<Integer>[] adj, int[] color, int i, int C) {
        Arrays.fill(color, -1);
        return check(adj, color, 0, i, C);
    }

    public static boolean check(List<Integer>[] adj, int[] color, int currNode, int n, int C) {

        if (currNode == n) return true;

        for (int i = 0; i < C; i++) {
            if (isSafe(adj, color, i, currNode)) {
                color[currNode] = i;
                if (check(adj, color, currNode + 1, n, C)) return true;
            }
        }
        return false;
    }

    public static boolean isSafe(List<Integer>[] adj, int[] color,
                                 int currColor, int currNode) {

        List<Integer> neighbour = adj[currNode];

        for (int next : neighbour) {
            if (color[next] != -1 && color[next] == currColor) return false;
        }
        return true;
    }
}

/*
    Try Simple Backtracking Problem.
 */