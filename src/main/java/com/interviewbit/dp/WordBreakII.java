package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {

        WordBreakII obj = new WordBreakII();
        String A = "catsanddog";
        List<String> B = Arrays.asList("cat", "cats", "and", "sand", "dog");

        List<String> result = obj.wordBreak(A, B);
        System.out.println(result);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        List<String>[] dp = new ArrayList[n + 1];

        dp[0] = new ArrayList<>();
        Set<String> dicSets = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j, i);
                if (dicSets.contains(subString)) {
                    List<String> preMatch = dp[j];

                    if (preMatch != null) {
                        if (dp[i] == null) {
                            dp[i] = new ArrayList<>();
                        }

                        if (j == 0)
                            dp[i].add(subString);
                        else {
                            for (String str : preMatch) {
                                String newString = str + " " + subString;
                                dp[i].add(newString);
                            }
                        }
                    }
                }
            }
        }
        return dp[n] == null ? new ArrayList<>() : dp[n];
    }
}

/*
    Read the Basic Word Break I and you shall be able to do this without any problem.

 */
