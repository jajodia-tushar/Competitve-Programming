package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class WordBreak {

    public static void main(String[] args) {

        WordBreak obj = new WordBreak();
        String A = "myinterviewtrainer";
        List<String> B = List.of("trainer", "my", "interview");
        boolean result = obj.wordBreak(A, B);
        System.out.println(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dictSet = new HashSet<>(wordDict);
        boolean[] isPossible = new boolean[s.length() + 1];
        isPossible[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (isPossible[j] && dictSet.contains(s.substring(j, i))) {
                    isPossible[i] = true;
                }
            }
        }
        return isPossible[s.length()];
    }
}

/*
    See it is simple if you are observe carefully.
    You Dp[i] will store the number of different sentences possible ending at ith index.

    now to find this, see you need to check for all the suffixes. If the the word represented
    but current suffix is in the dictionary then you can add this suffix at the end of all the
    previous possible words.

    Eg if you are trying to find the dp[i] for catsanddogs
    and currently you are at position 7th position.

    i.e. you have to find dp[7].

    So you have to check all the suffix i.e catsand atsand tsand sand and nd d.

    now when you are checking for the suffix sand you realize that "sand" is in the dictionary so you can add
    "sand" word in all the words that were formed previously upto cat. --> cat sand.

    also when you are at "and" you realize that "and" is also in the dictionary and you can add "and" at the end of
    every word to get the new word.
    This way you progress.



 */
