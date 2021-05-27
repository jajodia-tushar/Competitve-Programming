package com.leetcode.maychallenge;

import java.util.*;

/*
Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.


Example 1:

Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".


Constraints:

1 <= words.length <= 15000
1 <= words[i].length <= 10
1 <= prefix.length, suffix.length <= 10
words[i], prefix and suffix consist of lower-case English letters only.
At most 15000 calls will be made to the function f.
 */

public class PrefixAndSuffixSearch {

    Trie preTrie;
    Trie suffTrie;

    public static void main(String[] args) {

        String[] strings = {"apple","amantushare","appplee"};
        PrefixAndSuffixSearch obj = new PrefixAndSuffixSearch(strings);
        int result = obj.f("a", "e");
        System.out.println(result);

    }

    public PrefixAndSuffixSearch(String[] words) {

        preTrie = new Trie();
        suffTrie = new Trie();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            preTrie.insert(word, i, 0, length, 1);
            suffTrie.insert(word, i, length - 1, -1, -1);
        }
    }

    public int f(String prefix, String suffix) {

        ArrayList<Integer> pre = preTrie.search(prefix, 0, prefix.length(), 1);
        ArrayList<Integer> suff = suffTrie.search(suffix, suffix.length() - 1, -1, -1);
//        System.out.println(pre);
        int svix = suff.size() - 1, pvix = pre.size() - 1;
        while (svix >= 0 && pvix >= 0) {
            int sVal = suff.get(svix), pVal = pre.get(pvix);
            if (sVal == pVal) return sVal;
            if (sVal > pVal) svix--;
            else pvix--;
        }
        return -1;
    }
}

class Trie {

    public Trie[] children;
    public ArrayList<Integer> values;

    Trie() {
        this.children = new Trie[26];
        this.values = new ArrayList<>();
    }

    public void insert(String word, int indexWord, int start, int end, int step) {
        Trie current = this;
        for (int i = start; i != end; i += step) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Trie();
            }
            current = current.children[index];
            current.values.add(indexWord);
        }
    }

    public ArrayList<Integer> search(String word, int start, int end, int step) {

        Trie current = this;
        for (int i = start; i != end; i += step) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) return null;
            else current = current.children[index];
        }
        return current.values;
    }
}
