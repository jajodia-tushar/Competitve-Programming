package com.interviewbit.graph;

import java.util.*;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


 */


public class WordLadderI {

    public static void main(String[] args) {

        WordLadderI obj = new WordLadderI();
        String A = "a";
        String B = "c";
        String[] C = {"a", "b", "c"};

        int result = obj.solve(A, B, C);

//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        int result = obj.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> maps = new HashMap<>();
        int m = beginWord.length();
        int n = wordList.size();

        // Trying to replace Each Character with * and Creating a map of this newWord and List which
        // Contains all these Words.
        for (String word : wordList) {
            for (int j = 0; j < m; j++) {
                String newWord = word.substring(0, j) + "*" + word.substring(j + 1, m);
                addOrPut(maps, newWord, word);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new Pair<String, Integer>(beginWord, 1));
        visited.add(beginWord);
        Pair<String, List<String>> pair = new Pair(beginWord, new ArrayList<>() {{
            add(beginWord);
        }});
        while (!queue.isEmpty()) {

            Pair<String, Integer> curr = queue.poll();
            String w = curr.key;
            int level = curr.value;

            for (int i = 0; i < m; i++) {
                String newWord = w.substring(0, i) + "*" + w.substring(i + 1, m);

                if (maps.containsKey(newWord)) {
                    for (String word : maps.get(newWord)) {
                        if (!visited.contains(word)) {
                            visited.add(word);
                            queue.add(new Pair<String, Integer>(word, level + 1));
                        }

                        if (word.equals(endWord)) return level + 1;
                    }
                }
            }
        }
        return 0;
    }

    public void addOrPut(Map<String, List<String>> maps, String key, String value) {
        if (maps.containsKey(key)) {
            maps.get(key).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            maps.put(key, list);
        }
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

    static class Pair<U, V> {
        public U key;
        public V value;

        public Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}