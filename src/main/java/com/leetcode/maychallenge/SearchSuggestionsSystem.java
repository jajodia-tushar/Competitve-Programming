package com.leetcode.maychallenge;


import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed.



Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]


Constraints:

1 <= products.length <= 1000
There are no repeated elements in products.
1 <= Σ products[i].length <= 2 * 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.
 */
public class SearchSuggestionsSystem {

    public static void main(String[] args) {

        SearchSuggestionsSystem obj = new SearchSuggestionsSystem();
        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";

        List<List<String>> result = obj.suggestedProducts(products, searchWord);
        System.out.println(result);


    }

    List<List<String>> result;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        result = new ArrayList<>();

        int n = products.length;
        Arrays.sort(products);
        Trie root = new Trie();

        for (int i = 0; i < n; i++) {
            String word = products[i];
            root.insert(word);
        }


        for (int i = 0; i < searchWord.length(); i++) {

            String word = searchWord.substring(0, i + 1);
            List<String> innerResult = root.search(word);
            result.add(innerResult);
            System.out.println(innerResult);

        }

        return result;

    }


    class Trie {

        Trie[] children;
        List<String> indexList;

        public Trie() {
            this.children = new Trie[26];
            this.indexList = new ArrayList<>();
        }


        public void insert(String word) {

            int n = word.length();
            Trie root = this;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';

                if (root.children[index] == null) {
                    root.children[index] = new Trie();
                }

                root = root.children[index];
                root.indexList.add(word);
            }
        }

        public List<String> search(String word) {

            int n = word.length();
            Trie root = this;

            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';

                if (root.children[index] == null) {
                    return new ArrayList<>();
                }

                root = root.children[index];
            }
            return root.indexList.stream().limit(3).collect(Collectors.toList());
        }


    }


}
