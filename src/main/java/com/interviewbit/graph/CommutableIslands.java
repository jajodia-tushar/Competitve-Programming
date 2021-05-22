package com.interviewbit.graph;

import java.util.PriorityQueue;

public class CommutableIslands {

    public static void main(String[] args) {
        CommutableIslands obj = new CommutableIslands();
        int A = 4;
        int[][] B = {{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}};
        int result = obj.solve(A, B);
        System.out.println(result);
    }


    public int solve(int A, int[][] B) {

        boolean[] visited = new boolean[A + 1];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        Pair pair = new Pair(1, -1, 0);
        queue.add(pair);
        int totalCost = 0;

        while (!queue.isEmpty()) {
            Pair currentNode = queue.remove();
//            System.out.println(currentNode.weight);
            if (visited[currentNode.vertex]) continue;
            visited[currentNode.vertex] = true;
            totalCost += currentNode.weight;
            for (int i = 0; i < B.length; i++) {
                if (B[i][0] == currentNode.vertex && !visited[B[i][1]]) {
                    Pair newNode = new Pair(B[i][1], currentNode.vertex, B[i][2]);
                    queue.add(newNode);
                }

                if (B[i][1] == currentNode.vertex && !visited[B[i][0]]) {
                    Pair newNode = new Pair(B[i][0], currentNode.vertex, B[i][2]);
                    queue.add(newNode);
                }
            }
        }

        return totalCost;
    }
}

class Pair implements Comparable<Pair> {
    public int vertex;
    public int preVertex;
    public int weight;

    public Pair(int vertex, int preVertex, int weight) {
        this.vertex = vertex;
        this.preVertex = preVertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair pair) {
        return Integer.compare(this.weight, pair.weight);
    }
}
