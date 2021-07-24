package com.interviewbit.graph;


import java.util.ArrayList;
import java.util.LinkedList;

/*

    Hamiltonian Path – A simple path in a graph G that passes through every vertex exactly once is called a Hamiltonian path.
    Hamiltonian Circuit – A simple circuit in a graph G that passes through every vertex exactly once is called a Hamiltonian circuit.

    Question can be to print all Possible Hamiltonian Path and Cycles.

    End all the Hamiltonian path with a dot and Hamiltonian Cycle with Star.


    Paths to travel each nodes using each edge (Seven Bridges of Königsberg)
            For Explanation on this Question Look in Copy No 5. page no 17 .
            It's relate to Hamiltonian Path and Euler's Path.

            Euler's Path and Circuit has the necessary and sufficient condition.
            It says that if in a graph has only two vertex with odd inDegree then it has euler's path
            If all it's node has even inDegree only it has euler's circuit.

 */
public class HamiltonianPathAndCycle {

    public static void main(String[] args) {

        int n = 7;
        int[][] edges = {{0, 3}, {0, 2}, {2, 4}, {3, 5}, {3, 4}, {5, 6}, {6, 1}, {5, 1}, {4, 1}};
        ArrayList<String> result = getHamiltonianPathAndCycle(n, edges);
        System.out.println(result);

    }

    public static ArrayList<String> getHamiltonianPathAndCycle(int n, int[][] edges) {

        LinkedList<Integer>[] adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        ArrayList<String> result = new ArrayList<>();
        getPaths(0, adj, result, visited, 0 + "", 0);
        return result;
    }

    private static void getPaths(int currNode, LinkedList<Integer>[] adj, ArrayList<String> result, boolean[] visited, String pathSoFar, int source) {
        LinkedList<Integer> neighbours = adj[currNode];
        if (pathSoFar.length() == visited.length) {
            for (int next : neighbours) {
                if (next == source) {
                    result.add(pathSoFar + "*");
                    return;
                }
            }
            result.add(pathSoFar + ".");
            return;
        }

        visited[currNode] = true;
        for (int next : neighbours) {
            if (!visited[next]) {
                getPaths(next, adj, result, visited, pathSoFar + next, source);
            }
        }
        visited[currNode] = false;

    }
}


/*
    Simple DFS Right.
    Nothing Here.
    Just Look and return.
 */