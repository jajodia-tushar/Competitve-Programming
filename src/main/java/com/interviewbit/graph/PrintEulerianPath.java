package com.interviewbit.graph;

import javax.swing.border.SoftBevelBorder;
import java.util.LinkedList;

public class PrintEulerianPath {

    public static void main(String[] args) throws Exception {

        PrintEulerianPath obj = new PrintEulerianPath();
//        int[][] edges = {{0, 2}, {2, 3}, {1, 0}, {1, 2}, {1, 3}};
        int[][] edges = {{1, 0}, {0, 3}, {3, 4}, {2, 1}, {2, 0}};
        int nodes = 5;
        String result = obj.getEulerianPath(edges, nodes);
        System.out.println(result);
    }

    public String getEulerianPath(int[][] edges, int nodes) throws Exception {

        LinkedList<Node>[] adj = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adj[start].add(new Node(end));
            adj[end].add(new Node(start));
        }

        int oddVertex = -1;
        int oddCount = 0;
        for (int i = 0; i < nodes; i++) {
            LinkedList<Node> vertex = adj[i];
            if (vertex.size() % 2 == 1) {
                oddCount++;
                oddVertex = i;
            }
        }

        if (oddCount == 0) {
            return calculatePath(0, adj) + "*";
        } else if (oddCount == 2) {
            return calculatePath(oddVertex, adj) + ".";
        } else {
            throw new Exception("No Euler Path or Circuit Possible");
        }

    }

    public String calculatePath(int currNode, LinkedList<Node>[] adj) {

        String result = "";
        LinkedList<Node> neighbours = adj[currNode];

        for (Node next : neighbours) {
            if (!next.isRemoved && isValidPath(currNode, next.vertex, adj)) {
                removeEdge(currNode, next.vertex, adj);
                result += String.valueOf(currNode) + " -- " + String.valueOf(next.vertex) + "|";
                result += calculatePath(next.vertex, adj);
            }
        }
        return result;
    }

    public boolean isValidPath(int u, int v, LinkedList<Node>[] adj) {

        int n = adj.length;
        LinkedList<Node> neighbours = adj[u];
        int count = 0;

        for (Node next : neighbours) {
            if (!next.isRemoved) count++;
        }

        if (count == 1) return true;

        boolean[] visited = new boolean[n];

        removeEdge(u, v, adj);
        int count1 = countDFSNodes(u, adj, visited);

        addEdge(u, v, adj);
        visited = new boolean[n];
        int count2 = countDFSNodes(u, adj, visited);

        return count2 <= count1;
    }

    public void addEdge(int u, int v, LinkedList<Node>[] adj) {
        for (Node next : adj[u]) {
            if (next.vertex == v) {
                next.isRemoved = false;
            }
        }
        for (Node next : adj[v]) {
            if (next.vertex == u) {
                next.isRemoved = false;
            }
        }
    }

    public void removeEdge(int u, int v, LinkedList<Node>[] adj) {
        for (Node next : adj[u]) {
            if (next.vertex == v) {
                next.isRemoved = true;
            }
        }
        for (Node next : adj[v]) {
            if (next.vertex == u) {
                next.isRemoved = true;
            }
        }
    }

    public int countDFSNodes(int currNode, LinkedList<Node>[] adj, boolean[] visited) {

        visited[currNode] = true;
        int count = 1;
        LinkedList<Node> neighbours = adj[currNode];
        for (Node next : neighbours) {
            if (!next.isRemoved && !visited[next.vertex]) {
                count += countDFSNodes(next.vertex, adj, visited);
            }
        }
        return count;
    }

    static class Node {
        public int vertex;
        public boolean isRemoved;

        Node(int vertex) {
            this.vertex = vertex;
            isRemoved = false;
        }
    }
}

/*
    Just Remember two things to Print the Eulerian Path.
    Start from Odd Degree Vertex if there exist any.
    Don't burn the bridge. (Articulation Edge)

    No need to write the extra code for Articulation Point.
    You and use the concept of removing edge for finding bridge.
    If you remove current edge and count the number of nodes using dfs and
    count without removing if there is any difference in the count
    it means that this particular edge is acting as bridge for
    at least one vertex.

    But if there is just one node after this vertex then you can visit this
    one right.


 */