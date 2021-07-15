package com.leetcode.julychallenge;

/*
order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.

Return any permutation of str (as a string) that satisfies this property.

Example:
Input:
order = "cba"
str = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.


Note:

order has length at most 26, and no character is repeated in order.
str has length at most 200.
order and str consist of lowercase letters only.
 */

import java.util.Arrays;
import java.util.HashMap;

public class CustomSortString {

    public static void main(String[] args) {

        CustomSortString obj = new CustomSortString();
        String order = "acb";
        String str = "abced";
        String result = obj.customSortString(order, str);
        System.out.println(result);

    }

    public String customSortString(String order, String str) {

        int n = order.length();
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Character ch = order.charAt(i);
            maps.put(ch, i);
        }

        Character[] strArray = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strArray[i] = str.charAt(i);
        }

        Arrays.sort(strArray, (a, b) -> {
            int aIndex = maps.getOrDefault(a, -1);
            int bIndex = maps.getOrDefault(b, -1);

            if (aIndex != -1 && bIndex != -1)
                return aIndex - bIndex;

            if (bIndex != -1) {
                return 1;
            }

            if (aIndex != -1)
                return -1;

            return a.compareTo(b);
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
                result.append(strArray[i]);
        }

        return result.toString();
    }
}
