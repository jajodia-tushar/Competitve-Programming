package com.interviewbit.nonlinear.graph;

import java.util.*;

public class Graph {

    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        g.BFS(2);
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        g.DFS(2);
    }

    private int numberOfVertices;
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        this.adjacencyList.get(v).add(w);
    }

    void BFS(int start) {

        boolean[] visited = new boolean[this.numberOfVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;

        queue.add(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.println("Visited Node: " + currentNode);
            ArrayList<Integer> neighbours = this.adjacencyList.get(currentNode);
            for (int otherNodes : neighbours) {
                if (!visited[otherNodes]) {
                    visited[otherNodes] = true;
                    queue.add(otherNodes);
                }
            }
        }
    }

    void DFS(int start) {

        boolean[] visited = new boolean[this.numberOfVertices];
        Stack<Integer> stack = new Stack<>();
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            System.out.println("Visited Node: " + currentNode);
            ArrayList<Integer> neighbours = this.adjacencyList.get(currentNode);
            for (int otherNodes : neighbours) {
                if (!visited[otherNodes]) {
                    visited[otherNodes] = true;
                    stack.push(otherNodes);
                }
            }
        }


    }

}
