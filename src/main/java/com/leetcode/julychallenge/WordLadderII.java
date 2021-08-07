package com.leetcode.julychallenge;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 1000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */

import java.lang.invoke.WrongMethodTypeException;
import java.util.*;

public class WordLadderII {

    public static void main(String[] args) {

        WordLadderII obj = new WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        obj.findLadders(beginWord, endWord, wordList);

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> maps = new HashMap<>();
        Set<String> wordSets = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        List<String> currList = new ArrayList<>();
        currList.add(beginWord);

        bfs(maps, beginWord, wordSets);
        System.out.println(maps);
        backTrack(result, beginWord, endWord, maps, currList);

        return result;
    }

    public List<String> getNeighbours(String word, Set<String> wordSets) {

        int n = word.length();
        char[] charArray = word.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char oldChar = charArray[i];
            for (int j = 0; j < 26; j++) {
                char newChar = (char) ('a' + j);
                charArray[i] = newChar;
                String newWord = String.valueOf(charArray);
                if (newChar != oldChar && wordSets.contains(newWord)) {
                    result.add(newWord);
                }
            }
            charArray[i] = oldChar;
        }
        return result;
    }

    public void bfs(Map<String, List<String>> maps, String beginWord, Set<String> wordSets) {

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

//        wordSets.remove(beginWord);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> currLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                List<String> neighbours = getNeighbours(currWord, wordSets);
                maps.put(currWord, neighbours);

                for (String word : neighbours) {
                    currLevel.add(word);
                    if (!visited.contains(word)) {
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }

            for (String word : currLevel) {
                wordSets.remove(word);
            }
        }
    }

    public void backTrack(List<List<String>> result, String currWord, String finalWord, Map<String, List<String>> maps, List<String> currList) {

        List<String> neighbours = maps.getOrDefault(currWord, new ArrayList<>());
        for (String next : neighbours) {

            List<String> newList = new ArrayList<>(currList);
            newList.add(next);
            if (next.equals(finalWord)) {
                result.add(newList);
                return;
            }

            backTrack(result, next, finalWord, maps, newList);
        }
    }
}
