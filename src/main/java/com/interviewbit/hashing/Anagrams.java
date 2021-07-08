package com.interviewbit.hashing;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

/*

Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'

Note:  All inputs will be in lower-case.

Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4.

dog and god are another set of anagrams which correspond to index 2 and 3.

The indices are 1 based ( the first element has index 1 instead of index 0).

Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.

 */

public class Anagrams {

    public static void main(String[] args) {

        Anagrams obj = new Anagrams();
        String[] str = {"da", "cb"};
        int[][] anagrams = obj.anagrams(str);
        ArrayUtils.printArray(anagrams);

    }

    public int[][] anagrams(final String[] A) {
        Map<Integer, List<Integer>> sumToIndexes = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int sum = getSumOfChars(A[i]);
            if (sumToIndexes.containsKey(sum)) {
                sumToIndexes.get(sum).add(i + 1);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i + 1);
                sumToIndexes.put(sum, newList);
            }
        }
        int[][] result = new int[sumToIndexes.size()][];
        int i = 0;
        for (List<Integer> indexes : sumToIndexes.values()) {
            result[i++] = indexes.stream().mapToInt(j -> j).toArray();
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

    public long getSumOfCharsX(String A) {
        long sum = 31;
        int mod = 1_000_000_009;
        for (int i = 0; i < A.length(); i++) {
            int c = A.charAt(i) - '0';
            sum = (sum * c) % mod;
        }
        return sum;
    }
}

/*
    Anagrams will map to the same string if the characters in the string are sorted.
    We can maintain a hashmap with the key being the sorted string and the value
    being the list of strings ( which have the sorted characters as key ).


    Idea is to use the Some other technique to compare two string than Sorting.
    Because sorting is time consuming.
    We will use multiplication with Mod(10 ^ 9)
    and assume that values will be different.
    As Sorting everytime will result in TLE.
 */
