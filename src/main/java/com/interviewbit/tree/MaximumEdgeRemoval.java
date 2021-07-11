package com.interviewbit.tree;

import java.util.*;


// See Again.
public class MaximumEdgeRemoval {

    ArrayList<LinkedList<Integer>> adj;
    int result = 0;

    public static void main(String[] args) {
        MaximumEdgeRemoval obj = new MaximumEdgeRemoval();
        int[][] ints = {{6, 5}, {5, 1}, {1, 2}, {1, 3}, {1, 4}};
        int A = 6;
        int result = obj.solve(A, ints);
        System.out.println(result);
    }

    public int solve(int A, int[][] B) {
        adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new LinkedList<Integer>());
        }

        int n = B.length;
        for (int[] edge : B) {
            int start = edge[0];
            int end = edge[1];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        return removeEdges(n, A);
    }

    public int removeEdges(int n, int A) {
        boolean[] visited = new boolean[A + 1];
        dfs(1, visited);
        return result;
    }

    public int dfs(int u, boolean[] visited) {

        visited[u] = true;
        int currComponentNode = 0;
        LinkedList<Integer> neighbours = adj.get(u);
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                int subCom = dfs(neighbour, visited);
                if (subCom % 2 == 0) {
                    result++;
                } else {
                    currComponentNode += subCom;
                }
            }
        }
        return currComponentNode + 1;
    }
}

/*
    The Idea is Simple.
    Do DFS and in DFS return the number of Child nodes a particular Node has. (un visited)
    now it's Parent may decide to disconnect with this child based on the value returned.

    Suppose we start with node A.
    And A has a child B which has a Child C. Now C has 3 Child .
    We can Break this in
    A -- B and C with it's three Child.
    This way we have removed 1 edge at max.

    So Think and look the code and you shall be able to do this.

 */