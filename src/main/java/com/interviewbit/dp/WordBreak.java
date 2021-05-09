package com.interviewbit.dp;

import com.interviewbit.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class WordBreak {

    public static void main(String[] args) {

        WordBreak obj = new WordBreak();
        String A = "abbabaaaabbababaaaabababaaababaabaaabbaaaabbabaabbaababababaaababbbbbbabbabbaabbaaababbaabababaabbbbaabbbaabbaabbbbbababbabbbbbaaabbabbabbabaabbbbababaaaaaaaabbbabbaaabbbababbbabbabbaabaaaababbaababbbbabaaabbbbbabbababbbbaaababbbaabbbbabaabaaababbaababaabbbaabbbaaaabaaaaaaabbabbaabbaabbaaaabaabaaaabaabbabbababbabaaaaababbbabaaabaaaaabbabaabbabbbbaaaabbbabaabbaabbbbbaaabababbaaabbbaaabaaaaaaabbaaaabababaaabbaaaaaabbaabaabbaabbbbabbaababbbbbbabbaabaabaaabaababbbabaaaabaabbbbabbbabaaabbaaaaabbaabaaaabbababaaaabababbbbaabbaabaaaaabbbbbaababbbaaaaabbaaaaaaaaaaaaaaaababaaaaabbaaabaabaaabbabaababaabbabbabbabbabaabbbaaababaaaaabbababaaababbbbaabaababbbabbaabababbaababaabbbbaaabbaaabbabbaabbababbbbbabaaaaaabaaaaababbaabbbaaaaabbbabaabaaabbabbbbababbababbbabbbbaaaaaabaabbaabababaabbbabaaaaaba";
        String[] B =  {"a", "babbbba", "abbbba", "abb", "bbabbab", "b", "abbb", "aab", "abaaaaaa" };
        int result = obj.wordBreak(A, B);
        System.out.println(result);
    }

    public int wordBreak(String A, String[] B) {

        HashSet<String> sets = new HashSet<>(Arrays.asList(B));
        int n = A.length();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String wordToCheck = A.substring(j, i + 1);
                if (sets.contains(wordToCheck)) {
                    if( j > 0) dp[i] += dp[j - 1];
                    else dp[i] += 1;
                }
            }
        }

        ArrayUtils.printArray(dp);
        return dp[n - 1] != 0 ? 1 : 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
            //declare another List test to refer to the wordDict
        List<String> test = new ArrayList<>(wordDict);

        //declare a boolean dp array with size = n+1
        boolean dp[] = new boolean[s.length() + 1];

        //initialize dp[0] = true coz empty string is included in the dictionary
        dp[0] = true;

        //iterate over from i = 1 to <=n where n is the string length
        for (int i = 1; i <= s.length(); i++) {

            //iterate over j from 0 to < i each time checking if
            for (int j = 0; j < i; j++) {

                // if dp[j] && test.contains(s.substring(j,i)) for all values of j in 0 to < i is true
                if(dp[j] && test.contains(s.substring(j,i))) {
                    //then set dp[i] = true and break => the substring up to i can be segmented to form space separated sequence of                    dictionary words if there exists a j < i such that 0,j can be segmented into space sep dict words and j+1 to i                    exists in the dictionary.
                    dp[i] = true;
                    break;

                }
            } //end of inner loop
        }//end of outer loop

        //return the last entry od boolean dp array that of dp[n] to check whether whole string of n can be segmented to form space sep dict words.
        return dp[s.length()];

        //T O(n^2) S O(n)


    }
}
