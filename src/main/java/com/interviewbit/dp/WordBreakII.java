package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class WordBreakII {

    public static void main(String[] args) {

        WordBreakII obj = new WordBreakII();
        String A = "bbbbaaaabaaababaabbbbbbaaabbba";
        String[] B =  {"aabbaa", "ba", "bb", "ab", "abbbaabb", "aaaabbbaa", "bbbbaababb", "abababbbaa", "abaaaa" };

        String[] result = obj.wordBreak(A, B);
        ArrayUtils.printArray(result);
    }

    public String[] wordBreak(String A, String[] B) {

        HashSet<String> result = new HashSet<>();
        HashSet<String> sets = new HashSet<>(Arrays.asList(B));

        int n = A.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                String wordToCheck = A.substring(j, i + 1);
                if (sets.contains(wordToCheck)) {
                    ArrayList<String> temp = new ArrayList<>();
                    if( result.size() == 0){
                        result.add(wordToCheck);
                    }
                    else{
                        for (String str : result) {
                            temp.add(str + wordToCheck);
                        }
                        result.addAll(temp);
                    }
                }
            }
        }

        String[] strResult = new String[result.size()];
        int i = 0;

        for (String str : result) {
            strResult[i++] = str;
        }

        return strResult;
    }
}
