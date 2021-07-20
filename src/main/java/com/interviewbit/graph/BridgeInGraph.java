package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.LinkedList;

// SEE AGAIN
public class BridgeInGraph {

    public static void main(String[] args) {

        BridgeInGraph obj = new BridgeInGraph();

        int[][] edges = {{1, 2}, {1, 0}, {0, 3}, {2, 0}, {3, 4}};
        int[][] result = obj.getBridgeEdges(edges, 5);
        ArrayUtils.printArray(result);

    }

    private int[][] getBridgeEdges(int[][] edges, int n) {

        LinkedList<Integer>[] adj = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            adj[start].add(end);
            adj[end].add(start);
        }

        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        int[] discovery = new int[n];
        int[] lowestDiscovery = new int[n];
        boolean[] articulationPoint = new boolean[n];
        ArrayList<int[]> result = new ArrayList<>();
        parent[0] = -1;

        solve(parent, discovery, lowestDiscovery, visited, 0, adj, 0, result);

        int[][] resultInt = new int[result.size()][2];
        int i = 0;
        for (int[] res : result) {
            resultInt[i++] = res;
        }
        return resultInt;
    }

    public void solve(int[] parent, int[] discovery, int[] lowestDiscovery, boolean[] visited, int currNode,
                      LinkedList<Integer>[] adj, int currTime, ArrayList<int[]> result) {

        visited[currNode] = true;
        discovery[currNode] = lowestDiscovery[currNode] = ++currTime;
        LinkedList<Integer> neighbour = adj[currNode];

        for (int next : neighbour) {

            if (!visited[next]) {

                parent[next] = currNode;
                solve(parent, discovery, lowestDiscovery, visited, next, adj, currTime, result);
                lowestDiscovery[currNode] = Math.min(lowestDiscovery[currNode], lowestDiscovery[next]);

                if (lowestDiscovery[next] > discovery[currNode]) {
                    result.add(new int[]{currNode, next});
                }

            } else if (next != parent[currNode]) {
                lowestDiscovery[currNode] = Math.min(lowestDiscovery[currNode], discovery[next]);
            }
        }
    }

}
