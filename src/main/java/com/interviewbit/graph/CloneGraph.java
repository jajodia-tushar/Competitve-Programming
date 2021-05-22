package com.interviewbit.graph;

import java.util.*;

public class CloneGraph {

    HashMap<Integer, UndirectedGraphNode> map;
    HashSet<Integer> visited;


    public static void main(String[] args) {
        CloneGraph obj = new CloneGraph();

        UndirectedGraphNode root = new UndirectedGraphNode(10);
        UndirectedGraphNode first = new UndirectedGraphNode(10);
        UndirectedGraphNode second = new UndirectedGraphNode(10);
        UndirectedGraphNode third = new UndirectedGraphNode(10);
        UndirectedGraphNode fourth = new UndirectedGraphNode(10);
        UndirectedGraphNode fifth = new UndirectedGraphNode(10);

        root.neighbors.add(first);
        root.neighbors.add(second);
        first.neighbors.add(third);
        first.neighbors.add(fourth);
        third.neighbors.add(fifth);

        UndirectedGraphNode result = obj.cloneGraph(root);
        System.out.println(result);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<>();
        visited = new HashSet<>();
        UndirectedGraphNode result = dfs(node);
        return result;
    }


    public UndirectedGraphNode dfs(UndirectedGraphNode node) {

        int label = node.label;
        UndirectedGraphNode newNode;

        if (map.containsKey(label)) {
            newNode = map.get(label);
        } else {
            newNode = createNewLable(label);
        }

        for (UndirectedGraphNode x : node.neighbors) {
            int newLabel = x.label;
            if (!map.containsKey(newLabel)) {
                newNode.neighbors.add(dfs(x));
            } else {
                newNode.neighbors.add(map.get(newLabel));
            }
        }

        return newNode;
    }

    public UndirectedGraphNode createNewLable(int label) {
        UndirectedGraphNode node = new UndirectedGraphNode(label);
        map.put(label, node);
        return node;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
