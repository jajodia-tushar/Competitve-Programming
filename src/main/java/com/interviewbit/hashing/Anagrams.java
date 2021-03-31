package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;
import java.util.*;

/*
    Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
 */

public class Anagrams {

    public static void main(String[] args) {

        Anagrams obj = new Anagrams();
        String[] str = {"da","cb"};
        int[][] anagrams = obj.anagrams(str);
        ArrayUtils.printArray(anagrams);

    }

    public int[][] anagrams(final String[] A) {
        Map<Integer, List<Integer>> sumToIndexes = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int sum = getSumOfChars(A[i]);
            if (sumToIndexes.containsKey(sum)) {
                sumToIndexes.get(sum).add(i+1);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i+1);
                sumToIndexes.put(sum, newList);
            }
        }
        int[][] result = new int[sumToIndexes.size()][];
        int i = 0;
        for (List<Integer> indexes : sumToIndexes.values()) {
            result[i++] = indexes.stream().mapToInt(j->j).toArray();
        }
        return result;
    }

    private int getSumOfChars(String s) {
        int sum = 0;
        for (Character c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}
