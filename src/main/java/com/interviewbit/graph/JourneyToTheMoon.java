package com.interviewbit.graph;

import java.util.*;


/*
The member states of the UN are planning to send  people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

Example



There are  astronauts numbered  through . Astronauts grouped by country are  and . There are  pairs to choose from:  and .

Function Description

Complete the journeyToMoon function in the editor below.

journeyToMoon has the following parameter(s):

int n: the number of astronauts
int astronaut[p][2]: each element  is a  element array that represents the ID's of two astronauts from the same country
Returns
- int: the number of valid pairs

Input Format

The first line contains two integers  and , the number of astronauts and the number of pairs.
Each of the next  lines contains  space-separated integers denoting astronaut ID's of two who share the same nationality.

Constraints

Sample Input 0

5 3
0 1
2 3
0 4
Sample Output 0

6
Explanation 0

Persons numbered  belong to one country, and those numbered  belong to another. The UN has  ways of choosing a pair:


Sample Input 1

4 1
0 2
Sample Output 1

5
 */
public class JourneyToTheMoon {

    public static void main(String[] args) {

        JourneyToTheMoon obj = new JourneyToTheMoon();
        List<List<Integer>> lists = List.of(List.of(0, 1), List.of(2, 3), List.of(0, 4));
        long result = obj.journeyToMoon(5, lists);
        System.out.println(result);

    }

    public long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here

        Subset[] subsets = new Subset[n];
        for (int i = 0; i < n; i++) {
            subsets[i] = new Subset(i, 0);
        }

        for (List<Integer> edge : astronaut) {
            int x = find(edge.get(0), subsets);
            int y = find(edge.get(1), subsets);

            if (x != y) {
                union(x, y, subsets);
            }
        }

        for (int i = 0; i < n; i++) {
            int result = find(i, subsets);
        }

        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            maps.put(subsets[i].parent, maps.getOrDefault(subsets[i].parent, 0) + 1);
        }

        long sum = 0;
        long result = 0;
        boolean first = true;
        for (int value : maps.values()) {
            result += value * sum;
            sum += value;
        }
        return result;
    }

    public int find(int node, Subset[] subsets) {
        if (node == subsets[node].parent) return node;
        subsets[node].parent = find(subsets[node].parent, subsets);
        return subsets[node].parent;
    }

    public void union(int x, int y, Subset[] subsets) {

        int xParent = find(x, subsets);
        int yParent = find(y, subsets);

        if (subsets[xParent].rank < subsets[yParent].rank) {
            subsets[xParent].parent = yParent;
        } else if (subsets[xParent].rank > subsets[yParent].rank) {
            subsets[yParent].parent = xParent;
        } else {
            subsets[xParent].parent = yParent;
            subsets[yParent].rank++;
        }
    }

    static class Subset {
        public int parent;
        public int rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }
}

/*

    The Basic idea is to find connected components,
    And Number of nodes in each components.

    if a b c d are the number of nodes in each connected components then
    result is

    a * b + a * c + a * d + b * c + b * d + c * d

    a * b + (a + b) * c + (a + b + c) * d ...

    And List goes on.


 */