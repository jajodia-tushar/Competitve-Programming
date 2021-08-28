package com.interviewbit.graph;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class WordLadderII {

    public static void main(String[] args) {

        WordLadderII obj = new WordLadderII();
        String A = "hit";
        String B = "cog";
        ArrayList<String> C = ArrayUtils.asArrayList("hot", "dot", "dog", "lot", "log");

        List<List<String>> result = obj.findLadders(A, B, C);
        System.out.println(result);

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Map<String,List<String>> maps = new HashMap<>();
        Set<String> wordSets = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        List<String> currList = new ArrayList<>();
        currList.add(beginWord);

        bfs(maps,beginWord,wordSets);
        System.out.println(maps);
        backTrack(result,beginWord,endWord,maps,currList);

        return result;
    }

    public List<String> getNeighbours(String word,Set<String> wordSets){

        int n = word.length();
        char[] charArray = word.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char oldChar = charArray[i];
            for(int j = 0; j < 26; j++){
                char newChar = (char)('a' + j);
                charArray[i] = newChar;
                String newWord = String.valueOf(charArray);
                if(newChar != oldChar && wordSets.contains(newWord)){
                    result.add(newWord);
                }
            }
            charArray[i] = oldChar;
        }
        return result;
    }

    public void bfs(Map<String,List<String>> maps, String beginWord, Set<String> wordSets){

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        wordSets.remove(beginWord);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<String> currLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                String currWord = queue.poll();
                List<String> neighbours = getNeighbours(currWord,wordSets);
                maps.put(currWord,neighbours);

                for(String word : neighbours){
                    wordSets.remove(word);
                    if(!visited.contains(word)){
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }

            for(String word : currLevel){
                wordSets.remove(word);
            }
        }
    }

    public void backTrack(List<List<String>> result, String currWord, String finalWord,Map<String,List<String>> maps, List<String> currList){

        List<String> neighbours = maps.getOrDefault(currWord,new ArrayList<>());
        for(String next : neighbours){

            List<String> newList = new ArrayList<>(currList);
            newList.add(next);
            if( next.equals(finalWord)){
                result.add(newList);
                return;
            }

            backTrack(result,next,finalWord,maps,newList);
        }
    }
}
