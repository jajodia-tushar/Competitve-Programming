package com.interviewbit.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstraSAlgorithm {

    static class Node implements Comparable<Node> {
        int vertex;
        int key;

        public Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        @Override
        public int compareTo(Node node) {
            int value = this.key - node.key;
            if (value == 0) return this.vertex - node.vertex;
            return value;
        }
    }

    static class Edge {
        public int src;
        public int dest;
        public int cost;

        public Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    int[] solve(int[][] connections, int numberOfNodes) {

        LinkedList<Edge>[] adj = new LinkedList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : connections) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            Edge direct = new Edge(src, dest, cost);
            Edge iDirect = new Edge(dest, src, cost);
            adj[src].add(direct);
            adj[dest].add(iDirect);
        }

        boolean[] visited = new boolean[numberOfNodes];
        Node[] nodesArray = new Node[numberOfNodes];
        int[] result = new int[numberOfNodes];
        Arrays.fill(result, 0);

        for (int i = 0; i < numberOfNodes; i++) {
            nodesArray[i] = new Node(i, Integer.MAX_VALUE);
        }

        visited[0] = true;
        nodesArray[0].key = 0;
        // We could Have used the PriorityQueue
        // As well but Removing Node from TreeSet is Quite
        // Easy.
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(nodesArray[0]);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            visited[currNode.vertex] = true;
            LinkedList<Edge> neighbours = adj[currNode.vertex];

            for (Edge edge : neighbours) {
                int neighbour = edge.dest;
                int cost = edge.cost + currNode.key;
                Node node = nodesArray[neighbour];

                if (!visited[neighbour]) {
                    if (nodesArray[neighbour].key > cost) {
                        node.key = cost;
                        queue.add(node);
                        result[neighbour] = cost;
                    }
                }
            }
        }

        return result;
    }

    public void printTee(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " --> " + arr[i]);
        }
    }

    public static void main(String[] args) {

        DijkstraSAlgorithm obj = new DijkstraSAlgorithm();
        int[][] edges = {
                {0, 1, 4}, {0, 7, 8}, {1, 2, 8},
                {1, 7, 11}, {2, 3, 7}, {2, 8, 2},
                {2, 5, 4}, {3, 4, 9}, {3, 5, 14},
                {4, 5, 10}, {5, 6, 2}, {6, 7, 1},
                {6, 8, 6}, {7, 8, 7}
        };
        int[] result = obj.solve(edges, 9);
        obj.printTee(result);
    }
}


/*
    See Prim's Algorithm is Quite easy.
    Just You select a Node and then
    You relax it's neighbours. [ Relaxing is not same as in Dijkstra's]
    Then You select the minimum from the Unvisited Nodes.

    Here we can use PriorityQueue to get the minimum every time.
    But then since we need to relax the node we will require
    to remove and add the relaxed nodes again and again.
    So we are using TreeSet instead of PriorityQueue.

    See There are two things,
    We need TreeSet and here we need to store the vertex information [Which Vertex]
    and it's cost so for this we have created the class Node.
    And we need to store the weight of each Edge so we created
    Edge Class.

    Rest is Simple.
    We need to remove and add again and again because If we change the value of the
    object after it has been inserted in the TreeSet, we can't sort that.
    So We remove and add it again.


 */