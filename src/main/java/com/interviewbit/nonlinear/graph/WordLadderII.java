package com.interviewbit.nonlinear.graph;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;


// To Be Completed. BookMarked.
public class WordLadderII {

    public static void main(String[] args) {

        WordLadderII obj = new WordLadderII();
        String A = "hit";
        String B = "cog";
        ArrayList<String> C = ArrayUtils.asArrayList("hot", "dot", "dog", "lot", "log");

        ArrayList<ArrayList<String>> result = obj.findLadders(A, B, C);
        System.out.println(result);

    }

    public ArrayList<ArrayList<String>>
    findLadders(String start, String end, ArrayList<String> dict) {

        int n = dict.size();
        LinkedList<Integer>[] adj = new LinkedList[n + 2];
        boolean[] visited = new boolean[n + 2];
        int[] minValue = new int[n + 2];
        ArrayList<Integer>[] parent = new ArrayList[n + 2];

        for (int i = 0; i < n + 2; i++) {
            adj[i] = new LinkedList<>();
            visited[i] = false;
            minValue[i] = Integer.MAX_VALUE;
            parent[i] = new ArrayList<>();
            parent[i].add(-1);
        }

        for (int i = 0; i < n; i++) {
            String A = dict.get(i);
            for (int j = i + 1; j < n; j++) {
                String B = dict.get(j);
                if (isValidTransformation(A, B, 0, 0, 1)) {
                    adj[i + 1].add(j + 1);
                    adj[j + 1].add(i + 1);
                }
            }

            if (isValidTransformation(start, A, 0, 0, 1)) {
                adj[0].add(i + 1);
                adj[i + 1].add(0);
            }

            if (isValidTransformation(end, A, 0, 0, 1)) {
                adj[n + 1].add(i + 1);
                adj[i + 1].add(n + 1);
            }
        }

        minValue[0] = 0;

        for (int i = 0; i < n + 2; i++) {

            int minIndex = getMinIndexFromNotVisited(minValue, visited);
            visited[minIndex] = true;

            LinkedList<Integer> neighbours = adj[i];
            for (int j = 0; j < neighbours.size(); j++) {

                int u = neighbours.get(j);

                if (!visited[u] && minValue[minIndex] != Integer.MAX_VALUE) {
                    if (minValue[minIndex] + 1 == minValue[u]) {
                        parent[u].add(minIndex);
                    } else if (minValue[minIndex] + 1 < minValue[u]) {
                        minValue[u] = minValue[minIndex] + 1;
                        parent[u] = new ArrayList<>();
                        parent[u].add(minIndex);
                    }
                }
            }

        }


        ArrayList<String> result = new ArrayList<>();
        ArrayList<ArrayList<String>> r = new ArrayList<>();
        r.add(result);

        return r;


    }

    public int getMinIndexFromNotVisited(int[] minValue, boolean[] visited) {

        int minIndex = -1;
        int minTillNow = Integer.MAX_VALUE;
        for (int i = 0; i < minValue.length; i++) {
            if (!visited[i] && minTillNow >= minValue[i]) {
                minTillNow = minValue[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


    public boolean isValidTransformation(String A, String B, int i, int j, int transformation) {
        if (transformation < 0) return false;
        if (i == A.length() || j == B.length()) return true;

        if (A.charAt(i) == B.charAt(j)) return isValidTransformation(A, B, i + 1, j + 1, transformation);
        else return isValidTransformation(A, B, i + 1, j + 1, transformation - 1);
    }
}
