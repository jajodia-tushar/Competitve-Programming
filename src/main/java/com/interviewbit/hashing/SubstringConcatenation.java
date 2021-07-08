package com.interviewbit.hashing;

/*
You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).
 */

import java.util.*;

public class SubstringConcatenation {
    Map<String, Integer> maps = new HashMap<>();
    int wordLength;
    int stringLength;

    public static void main(String[] args) {

    }

    public int[] findSubstring(String A, final String[] B) {

        int n = A.length();
        wordLength = B[0].length();
        stringLength = B.length;
        int concatenationLength = stringLength * wordLength;

        for (String str : B) {
            maps.put(str, maps.getOrDefault(str, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n - (concatenationLength - 1); i++) {
            String subString = A.substring(i, i + concatenationLength);
            boolean possible = checkIfContainsAllWords(subString);
            if (possible) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public boolean checkIfContainsAllWords(String subString) {

        Map<String, Integer> newMap = new HashMap<>(maps);

        int reqCount = stringLength;
        int count = 0;
        int wCount = wordLength;
        int n = subString.length();

        for (int i = 0; i < n; i += wCount) {
            String sub = subString.substring(i, i + wCount);
            if (newMap.containsKey(sub)) {
                int pcount = newMap.get(sub);
                if (pcount > 0) {
                    count += 1;
                    newMap.put(sub, pcount - 1);
                } else {
                    return false;
                }
            }
        }
        return reqCount == count;
    }
}

/*

    This Question seems intimidating, But you can keep Map to store the String and Count.
    And then validate for every possible Index.

 */