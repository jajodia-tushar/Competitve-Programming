package com.interviewbit.graph;


/*

    Watch the Video from Abdul bari.
    Then Follow the GFG Article.
    Try to understand the Condition.

 */

import com.interviewbit.utils.ArrayUtils;

import java.util.LinkedList;

// SEE AGAIN
public class ArticulationPoint {


    public static void main(String[] args) {

        ArticulationPoint obj = new ArticulationPoint();

        int[][] edges = {{0, 3}, {0, 1}, {3, 2}, {1, 2}, {2, 4}, {2, 5}, {4, 5}};
        int[] result = obj.getArticulationPoint(edges, 6);
        ArrayUtils.printArray(result);

    }


    public void solve(int[] parent, int[] discovery, int[] lowDiscover, boolean[] articulationPoint,
                      int currNode, boolean[] visited, LinkedList<Integer>[] adj, int currTime) {

        visited[currNode] = true;
        int children = 0;
        // This was the first time we have traversed this particular node.
        // Perfect time to assign the discovery time.
        discovery[currNode] = lowDiscover[currNode] = ++currTime;

        LinkedList<Integer> neighbours = adj[currNode];
        for (int next : neighbours) {
            if (!visited[next]) {
                children++;
                parent[next] = currNode;
                solve(parent, discovery, lowDiscover, articulationPoint, next, visited, adj, currTime);
                // Lowest Point of the Parent is going to be min of all children right ?
                // Making sense. Because we can traverse using the same back edge
                // our child has traversed to get the same value;
                lowDiscover[currNode] = Math.min(lowDiscover[currNode], lowDiscover[next]);

                if (parent[currNode] == -1 && children > 1)
                    articulationPoint[currNode] = true;
                else if (lowDiscover[next] >= discovery[currNode])
                    articulationPoint[currNode] = true;

            }
            // Here we are getting a possible back edge
            // Let's verify if it's not the parent of the currNode.
            // Ok Now we are sure this is the back edge.
            // Perfect time to set the lowest point right.
            else if (next != parent[currNode]) {
                lowDiscover[currNode] = Math.min(lowDiscover[currNode], discovery[next]);
            }
        }
    }

    public int[] getArticulationPoint(int[][] edges, int n) {

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

        parent[0] = -1;

        solve(parent, discovery, lowestDiscovery, articulationPoint, 0, visited, adj, 0);
        int resultSize = 0;
        for (int i = 0; i < n; i++) {
            if (articulationPoint[i]) resultSize++;
        }

        int[] result = new int[resultSize];
        resultSize = 0;
        for (int i = 0; i < n; i++) {
            if (articulationPoint[i]) result[resultSize++] = i;
        }
        return result;
    }
}
