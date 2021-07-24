package com.interviewbit.graph;

public class TravellingSalesManProblem {

    public static void main(String[] args) {


        TravellingSalesManProblem obj = new TravellingSalesManProblem();
        int n = 4;
        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int result = Integer.MAX_VALUE;
        result = obj.tsp(graph, visited, 0, n, 1, 0, result);
        System.out.println(result);
    }

    int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int result) {

        if (count == n && graph[currPos][0] > 0) {
            result = Math.min(result, cost + graph[currPos][0]);
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i] && graph[currPos][i] > 0) {
                v[i] = true;
                result = tsp(graph, v, i, n, count + 1,
                        cost + graph[currPos][i], result);
                v[i] = false;
            }
        }
        return result;
    }
}

/*
    This is kind of NP Hard Problem Which Can't be solved better than N^N.
    So Using Back Tracking.
    We can optimized this little bit
    But can't do much in this question.


 */
