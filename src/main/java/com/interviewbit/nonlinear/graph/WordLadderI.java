package com.interviewbit.nonlinear.graph;

import java.util.LinkedList;

public class WordLadderI {

    public static void main(String[] args) {

        WordLadderI obj = new WordLadderI();
        String A = "hit";
        String B = "cog";
        String[] C = {"hot", "dot", "dog", "lot", "log"};

        int result = obj.solve(A, B, C);
        System.out.println(result);

    }

    public int solve(String A, String B, String[] C) {

        int n = C.length;
        int m = C[0].length();
        LinkedList<Integer>[] adj = new LinkedList[n + 2];
        int[] minValue = new int[n + 2];
        boolean[] visited = new boolean[n + 2];

        for (int i = 0; i < n + 2; i++) {
            adj[i] = new LinkedList<>();
            minValue[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            String first = C[i];
            for (int j = i + 1; j < n; j++) {
                String second = C[j];
                if (isValidTransformation(first, second, 0, 0, 1)) {
                    adj[i + 1].add(j + 1);
                    adj[j + 1].add(i + 1);
                }
            }

            if (isValidTransformation(A, first, 0, 0, 1)) {
                adj[i + 1].add(0);
                adj[0].add(i + 1);
                ;
            }

            if (isValidTransformation(B, first, 0, 0, 1)) {
                adj[i + 1].add(n + 1);
                adj[n + 1].add(i + 1);
            }
        }


        minValue[0] = 0;

        for (int i = 0; i < n + 2; i++) {

            int minIndex = getMinFromNotVisited(minValue, visited);
            visited[minIndex] = true;


            LinkedList<Integer> neighbours = adj[minIndex];

            for (int j = 0; j < neighbours.size(); j++) {
                int v = neighbours.get(j);
                if (!visited[v] && minValue[minIndex] != Integer.MAX_VALUE &&
                        ((minValue[minIndex] + 1) < minValue[v])) {
                    minValue[v] = minValue[minIndex] + 1;
                }
            }
        }


        return minValue[n + 1] + 1;

    }


    public int getMinFromNotVisited(int[] minValue, boolean[] visited) {


        int minIndex = -1;
        int minTillNow = Integer.MAX_VALUE;
        int n = minValue.length;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && minValue[i] <= minTillNow) {
                minTillNow = minValue[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    public boolean isValidTransformation(String A, String B, int i, int j, int tranformation) {

        if (tranformation < 0) return false;
        if (i == A.length() || j == B.length()) return true;
        if (A.charAt(i) == B.charAt(j))
            return isValidTransformation(A, B, i + 1, j + 1, tranformation);
        else
            return isValidTransformation(A, B, i + 1, j + 1, tranformation - 1);
    }
}
